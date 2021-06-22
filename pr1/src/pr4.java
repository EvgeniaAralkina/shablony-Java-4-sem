import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class pr4 {
    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

///
        executor.submit(() -> {
            try {

                Thread.sleep(360);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });
        executor.submit(() -> {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Start");
        });
    }
}
