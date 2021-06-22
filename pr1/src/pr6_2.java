// паттерн абстрактная фабрика
public class pr6_2
{
    public interface AbstractChair {
        String sit();
    }

    public interface AbstractFactory {
        AbstractChair CreateAbstractChair();
    }

    static class Factory1 implements AbstractFactory {
        @Override
        public AbstractChair CreateAbstractChair() {
            return new VicChair();
        }
    }
    static class Factory2 implements AbstractFactory {
        @Override
        public AbstractChair CreateAbstractChair() {
            return new MFChair();
        }
    }
    static class Factory3 implements AbstractFactory {
        @Override
        public AbstractChair CreateAbstractChair() {
            return new MagicChair();
        }
    }

    static class MagicChair implements AbstractChair {
        @Override
        public String sit() {
            return "✨ Magic Chair ✨";
        }
    }

    static class VicChair implements AbstractChair {
        @Override
        public String sit() {
            return "Victorian Сhair";
        }
    }

    static class MFChair implements AbstractChair {
        @Override
        public String sit() {
            return "Multifunctional Сhair";
        }
    }

    static class Client {
        private AbstractChair chair1;

        Client(AbstractFactory factory) {
            chair1 = factory.CreateAbstractChair();
        }

        void Sit() {
            System.out.print("I sit on a " + chair1.sit() + "\n");
        }
    }
    public static void main(String[] args) {
        AbstractFactory factory1 = new Factory1();
        AbstractFactory factory2 = new Factory2();
        AbstractFactory factory3 = new Factory3();
        Client client1 = new Client(factory1);
        Client client2 = new Client(factory2);
        Client client3 = new Client(factory3);
        client1.Sit();
        client2.Sit();
        client3.Sit();
    }
}
