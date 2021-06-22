// стритель
public class pr6_3 {
    static class House{
        String materials;
        String location;
        int windows;
        int floors;

        @Override
        public String toString() {
            return "House{" +
                    "materials='" + materials + '\'' +
                    ", location='" + location + '\'' +
                    ", windows=" + windows +
                    ", floors=" + floors +
                    '}';
        }
    }

    public interface Builder {

        void setMaterials(String materials);

        void setWindows(int windows);

        void setFloors(int floors);

        void setLocation(String location);

        House getHouse();
    }

    static class House_1Builder implements Builder{
        private  House house = new House();

        public void setMaterials(String materials) {
            house.materials = materials;
        }

        public void setWindows(int windows) {
            house.windows = windows;
        }

        public void setFloors(int floors) {
            house.floors = floors;
        }
        public void setLocation(String location) {
            house.location = location;
        }

        public House getHouse(){ return house; }
    }

   /* static class House_2Builder implements Builder{
        private  House house;
        public void setName(String name) {
            house.name = name;
        }

        public void setMaterials(String materials) {
            house.materials = materials;
        }

        public void setWindows(int windows) {
            house.windows = windows;
        }

        public void setFloors(int floors) {
            house.floors = floors;
        }
    }*/
   static class Director{
        Builder builder = new House_1Builder();
        public void buildHouseOnTree(){
            builder.setMaterials("oak");
            builder.setWindows(4);
            builder.setFloors(1);
            builder.setLocation("forest");
        }
        public void buildLakeHouse(){
            builder.setMaterials("pine");
            builder.setWindows(8);
            builder.setFloors(2);
            builder.setLocation("at lake");
        }
       public House getHouse(){ return builder.getHouse(); }
    }

    public static void main(String[] args) {
        Director director = new Director();
        director.buildHouseOnTree();
        House house1 = director.getHouse();
        System.out.println(house1.toString());
        director.buildLakeHouse();
        House house2 = director.getHouse();
        System.out.println(house2.toString());
    }

}
