// паттерн Singleton
public class pr5 {
    public static class CatSingleton {
        String name;
        String color;
        private static CatSingleton instance;

        private CatSingleton(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public static synchronized CatSingleton getInstance(String name, String color) {
            if(instance == null) {
                instance = new CatSingleton(name, color);
                return instance;
            }
            System.out.println("Можно завести только одного котика!");
            return instance;
        }

        @Override
        public String toString() {
            return "имя: " + name + '\'' +
                    ", цвет: " + color + '\'';
        }
    }

    public enum DogSingleton {
        DOG("Бобик","мопс");
        DogSingleton(String бобик, String серый) {
        }
        public static DogSingleton getInstance() {
            return DOG;
        }
        public String info(){
            return "имя: Бобик, порода: мопс";
        }
    }

    public static class RatSingleton {

        public RatSingleton(String джерри, String черный) {
        }

        public static class SingletonHolder {
            public static final RatSingleton HOLDER_INSTANCE = new RatSingleton("Джерри", "черный");
        }

        public static RatSingleton getInstance() {
            return SingletonHolder.HOLDER_INSTANCE;
        }
        public String info(){
            return "имя: Джерри, цвет: черный";
        }

    }

    public static void main(String[] args) {
        CatSingleton cat = CatSingleton.getInstance("Рыжик", "рыжий");
        cat = CatSingleton.getInstance("снежинка","белый");
        System.out.println(cat.toString());

        DogSingleton dog = DogSingleton.getInstance();
        System.out.println(dog.info());

        RatSingleton rat = RatSingleton.getInstance();
        System.out.println(rat.info());
    }

}
