//паттерн команда
public class pr8_1 {
    // получатель
    public static class Light{
        public void turnOn(){
            System.out.println("The light is on");
        }
        public void turnOff(){
            System.out.println("The light is off");
        }
    }

    public interface Command{
        void execute();
    }

    public static class TurnOnLightCommand implements Command{
        private Light light;

        public TurnOnLightCommand(Light light){
            this.light=light;
        }

        public void execute(){
            light.turnOn();
        }
    }

    public static class TurnOffLightCommand implements Command{
        private Light light;

        public TurnOffLightCommand(Light light){
            this.light=light;
        }

        public void execute(){
            light.turnOff();
        }
    }
    // отправитель
    public static class Switch {
        private Command flipUp;
        private Command flipDown;

        public Switch(Command flipUp,Command flipDown){
            this.flipUp=flipUp;
            this.flipDown=flipDown;
        }

        public void flipUp(){
            flipUp.execute();
        }

        public void flipDown(){
            flipDown.execute();
        }
    }
    public static void main(String[] args){
        Light l=new Light();
        Command switchUp=new TurnOnLightCommand(l);
        Command switchDown=new TurnOffLightCommand(l);
        Switch s=new Switch(switchUp,switchDown);
        s.flipUp();
        s.flipDown();
    }
}
