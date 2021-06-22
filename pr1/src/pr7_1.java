// паттерн мост
public class pr7_1 {
    enum Color{
        BLUE,
        WHITE,
        CREAM,
        SMOKE,
        BLACK
    }
    interface Breed{
        String getBreed();
    }
    static class AbyssinianCat implements Breed{
        String breed = "Abyssinian cat";

        @Override
        public String getBreed() {
            return breed;
        }
    }
    static class AmericanShorthairCat implements Breed{
        String breed = "American shorthair cat";
        @Override
        public String getBreed() {
            return breed;
        }
    }
    static class BritishShorthairCat implements Breed{
        String breed = "British shorthair cat";
        @Override
        public String getBreed() {
            return breed;
        }
    }
    static class Cat{
        Breed breed;
        String breed1;
        Color color;
        String name;
        int age;
        String ownerName;

        @Override
        public String toString() {
            return "Cat{" +
                    "breed=" + breed1 +
                    ", color=" + color +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", ownerName='" + ownerName + '\'' +
                    '}';
        }

        public Cat(Breed breed, Color color, String name, int age, String ownerName) {
            this.breed = breed;
            this.color = color;
            this.name = name;
            this.age = age;
            this.ownerName = ownerName;
            breed1 = breed.getBreed();
        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat(new AbyssinianCat(), Color.BLUE, "Barsik", 4, "Ivan");
        System.out.print(cat.toString());

    }
}
