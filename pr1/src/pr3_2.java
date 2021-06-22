import java.util.Random;
import java.util.concurrent.Semaphore;

public class pr3_2 {
    public static class Map {
        int map[][] = new int [2][1000];
        int maxInd;
        private static final Semaphore semaphore = new Semaphore(1);

        Map() {
            for (int i =0; i < 1000; i++) {
                map[0][i] = 3141592;
                map[1][i] = 3141592;
            }
            maxInd = 0;
        }

        boolean searchKey(int key){
            for (int i=0; i<maxInd;i++)
                if (map[0][i]==key)
                    return true;
            return false;
        }

        void put(int key, int val){
            try {
                semaphore.acquire();
                if (!searchKey(key)) {
                    map[0][maxInd] = key;
                    map[1][maxInd] = val;
                    maxInd++;
                    semaphore.release();
                    return;
                }
                System.out.println("\nтакой ключ ("+ key +") уже существует");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        void del(int key) {
            try {
                semaphore.acquire();
                for (int i = 0; i < 1000; i++)
                    if (map[0][i] == key) {
                        for (int j = i; j < maxInd; j++) {
                            map[0][j] = map[0][j + 1];
                            map[1][j] = map[1][j + 1];
                        }
                        maxInd--;
                        map[0][maxInd] = 3141592;
                        map[1][maxInd] = 3141592;
                        semaphore.release();
                        return;
                    }
                System.out.println("\nвведенного ключа ("+ key +") не существует");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public int get(int key){
            try {
                semaphore.acquire();
                for (int i=0;i<=maxInd;++i){
                    if (map[0][i]==key){
                        semaphore.release();
                        return map[1][i];
                    }
                }
                System.out.println("\nтакого ключа ("+ key +") не существует ");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return -1;
        }

        boolean containsKey(int key){
            for (int i=0;i<=maxInd;++i)
                if (map[0][i]==key)
                    return true;
            return false;
        }

        boolean containsVal(int val){
            for (int i=0;i<=maxInd;++i)
                if (map[1][i]==val){
                    return true;
                }
            return false;
        }

        public void printAll(){
            try {
                semaphore.acquire();
                for(int i=0; i<maxInd; i++){
                    System.out.print(map[0][i]+": "+map[1][i]+"; ");
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        Random rand = new Random();
        for (int i=0; i<10; i++){
            map.put(i,rand.nextInt(100)+1);
        }
        map.printAll();

        Thread one = new Thread(()->{
            map.del(9);
            System.out.print("\n1 поток:\ncontains value 76: " + map.containsVal(76)+", contains key 8: " + map.containsKey(8)
                    + ", value with key 4: "+map.get(4));
        });

        Thread two = new Thread(()->{
            map.del(7);
            System.out.print("\n2 поток:\ncontains value 32: " + map.containsVal(32)+", contains key 7: " + map.containsKey(7)
                    + ", value with key 3: "+map.get(3)+"\n");
        });

        one.start();
        two.start();
        Thread.sleep(20000);
    }
}
