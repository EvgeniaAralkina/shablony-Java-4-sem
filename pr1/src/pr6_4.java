// копирующий паттерн
public class pr6_4 {
    static class Circle{
        private String color;
        private int R;

        public Circle(String color, int r) {
            this.color = color;
            R = r;
        }

        public Circle(Circle circle) {
            this.color = circle.color;
            R = circle.R;
        }

        public Circle clone(){return new Circle(this);}

        @Override
        public String toString() {
            return "Circle{" +
                    "color='" + color + '\'' +
                    ", R=" + R +
                    '}';
        }
    }

    public static void main(String[] args) {
        Circle c1 = new Circle("red", 8);
        Circle c2 = new Circle(c1);
        Circle c3 = c2.clone();
        System.out.println(c2);
        System.out.println(c3);
    }
}
