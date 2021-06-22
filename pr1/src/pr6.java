// паттерн фабричный метод
public class pr6 {
    interface Animal{
        String saySomething();
    }

    static class Cat implements Animal{
        String name = "cat";
        @Override
        public String saySomething() {
            return ("MEOW");
        }
    }

    static class Goose implements Animal{
        String name = "goose";
        @Override
        public String saySomething() {
          return ("Honk-honk");
        }
    }

    abstract static class WhatSay{
        public void speech(){
            Animal animal = createAnimal();
            System.out.print(animal.saySomething());
        }
        public abstract Animal createAnimal();
    }

    static class WhatCatSay extends WhatSay{
        @Override
        public Animal createAnimal() {
            return new Cat();
        }
    }

    static class WhatGooseSay extends WhatSay{
        @Override
        public Animal createAnimal() {
            return new Goose();
        }
    }

    public static void main(String[] args) {
        String name = "goose";
        WhatSay whatSay;
        if (name=="cat"){
            whatSay = new WhatCatSay();
        }
        else { whatSay = new WhatGooseSay(); }
        whatSay.speech();
    }
}
