import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        String[] toyStrings = {
            "1 Конструктор 2",
            "2 Робот 2",
            "3 Кукла 6",
            "4 Машинка 3",
            "5 Мяч 4",
            "6 Лошадка 5",
            "7 Поезд 1",
            "8 Книга 3",
            "9 Гитара 2"
        };

        store.fillToysFromStrings(toyStrings);

        try (FileWriter writer = new FileWriter("result.txt")) {
            for (int i = 0; i < 3; i++) {
                int result = store.get();
                String output = "Выпала игрушка с id: " + result;

                writer.write(output + "\n");

                System.out.println(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

