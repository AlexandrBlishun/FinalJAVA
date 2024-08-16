import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {
    private PriorityQueue<Toy> toyQueue;

    public ToyStore() {
        toyQueue = new PriorityQueue<>();
    }

    public void addToy(int id, String name, int weight) {
        Toy toy = new Toy(id, name, weight);
        toyQueue.offer(toy);
    }

    public int get() {
        int totalWeight = toyQueue.stream().mapToInt(Toy::getWeight).sum();
        int randomValue = new Random().nextInt(totalWeight);

        int cumulativeWeight = 0;
        for (Toy toy : toyQueue) {
            cumulativeWeight += toy.getWeight();
            if (randomValue < cumulativeWeight) {
                return toy.getId();
            }
        }
        return -1; // На случай ошибки
    }

    public void fillToysFromStrings(String[] toyStrings) {
        for (String toyString : toyStrings) {
            String[] parts = toyString.split(" ");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int weight = Integer.parseInt(parts[2]);
            addToy(id, name, weight);
        }
    }
}
