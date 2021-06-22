// паттерн компановщик
import java.util.ArrayList;
import java.util.List;
public class pr7_2 {
    interface Car {
        void create(String color);
    }
    static class SportCar implements Car {
        public void create(String color) {
            System.out.println("Sport car color: " + color);
        }
    }
    static class CityCar implements Car {
        public void create(String color) {
            System.out.println("City car color: " + color);
        }
    }
    static class CreatingCars implements Car {
        private List<Car> cars = new ArrayList<Car>();
        public void create(String color) {
            for(Car car : cars) {
                car.create(color);
            }
        }
        public void add(Car s){
            this.cars.add(s);
        }
        public void clear(){
            System.out.println();
            this.cars.clear();
        }
    }

    public static void main(String[] args) {
        Car sportCar = new SportCar();
        Car cityCar = new CityCar();
        CreatingCars car = new CreatingCars();
        car.add(sportCar);
        car.add(cityCar);
        car.create("green");
        car.clear();
        car.add(sportCar);
        car.add(cityCar);
        car.create("white");
        }
    }
