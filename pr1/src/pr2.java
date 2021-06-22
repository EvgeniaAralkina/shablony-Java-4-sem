import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class pr2 {
    static class Human{
        int age;
        int weight;
        String firstName;
        String lastName;
        LocalDate birthDate;

        public Human (String firstName, String lastName,
                      LocalDate birthDate, int weight){
            this.age = 2021-birthDate.getYear();
            this.birthDate = birthDate;
            this.firstName = firstName;
            this.lastName = lastName;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "age=" + age +
                    ", weight=" + weight +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", birthDate=" + birthDate +
                    '}';
        }
    }

    public static ArrayList<Human> humans(){
        ArrayList<Human> humans = new ArrayList<>();
        Random random = new Random();
        String[] names = {"Oliver", "Ben", "Olga", "Jane", "Victor"};
        String[] names2 = {"Smith", "Baker", "Jones", "Williams", "Jackson"};
        LocalDate[] date = {LocalDate.of(random.nextInt(21)+2000,
                random.nextInt(11)+1, random.nextInt(30)+1),
                LocalDate.of(random.nextInt(99)+1900,
                        random.nextInt(11)+1, random.nextInt(30)+1)};

        for (int i =0;i<5;i++){
            humans.add(new Human(names[random.nextInt(5)],
                    names2[random.nextInt(5)], LocalDate.of(random.nextInt(100)+1921,
                    random.nextInt(11)+1, random.nextInt(30)+1), random.nextInt(60)+9));
        }
        System.out.println("Сортировка по дате рождения:");
        Stream<Human> stream = humans.stream();
        stream.sorted(Comparator.comparing(hum->hum.birthDate))
                .forEach(System.out::println);

        stream = humans.stream();
        System.out.println("\nфильтрация по возрасту меньше, чем 50:");
        stream.filter(hum->hum.age<50).forEach(System.out::println);

        stream = humans.stream();
        System.out.println("\nсортировка по весу:");
        stream.sorted(Comparator.comparing(hum->hum.weight)).forEach(System.out::println);

        stream = humans.stream();
        System.out.println("\nвсе имена:");
        String allNames = stream.map(hum->hum.firstName).collect(Collectors.joining(" "));
        System.out.print(allNames);

        return humans;
    }

    public static void main(String[] args) {
        humans();
    }
}
