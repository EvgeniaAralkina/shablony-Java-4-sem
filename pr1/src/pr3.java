import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class pr3 {
    public static class List {
        int list[] = new int [1000];
        int maxInd, max, min;
        float average;
        final Lock lock = new ReentrantLock();

        List() {
            for (int i : list) {
                i = 3141592;
            }
            maxInd = 0;
            max=min=3141592;
            average = 0f;
        }

        void add(int val){
            lock.lock();
            average+=val;
            list[maxInd] = val;
            if (val>max || max==3141592)
                max=val;
            if (val<min || min == 3141592)
                min = val;
            maxInd++;
            lock.unlock();
            }

        void del(int i)
        {
            lock.lock();
            if (i>maxInd-1)
            {
                System.out.print("index i = "+i+" out of range\n");
                lock.unlock();
                return;
            }
            average-=list[i];
            if (list[i]==max)
            {
                max=list[0];
                for (int j: list){
                    if (j>max && j!=list[i])
                        max=j;
                }
            } else if (list[i]==min){
                min=list[0];
                for (int j: list){
                    if (j<min || j!=list[i])
                        min=j;
                }
            }
            for (int j = i; j < maxInd; j++) {
                list[j] = list[j + 1];
            }
            list[maxInd-1]=3141592;
            maxInd--;
            lock.unlock();
        }

        public int searchValue(int val){
            lock.lock();
            for (int i=0;i<=maxInd;++i){
                if (list[i]==val){
                    lock.unlock();
                    return i;
                }
            }
            lock.unlock();
            return -1;
        }

        public int searchInd(int i){ return list[i];}

        public int findMax(){
            return max;
        }

        public  int findMin(){
            return min;
        }

        public float average(){
            return average/maxInd;
        }

        public void printAll(){
            for(int i=0;i<maxInd;i++){
                System.out.print(list[i]+" ");
            }
        }
    }

        public static void main(String[] args) throws InterruptedException {
            List list = new List();
            Random rand = new Random();
            for (int i=0; i<10; ++i){
                list.add(rand.nextInt(100)+1);
            }
            list.printAll();

            Thread one = new Thread(()->{
                list.del(9);
                list.del(0);
                System.out.print("\nMAX: "+list.findMax()+"   MIN: "+list.findMin()+"   AVERAGE: "+ list.average()+ " "+
                        "\nlist["+4+"]: "+ list.searchInd(4)+"\n" +
                        "element with value: "+ 89+ " has index: "+list.searchValue(45));
            });
            Thread two = new Thread(()->{
                list.del(7);
                list.del(0);
                System.out.print("\nMAX: "+list.findMax()+"   MIN: "+list.findMin()+"   AVERAGE: "+ list.average()+ " "+
                        "\nlist["+4+"]: "+ list.searchInd(4)+"\n" +
                        "element with value: "+ 33+ " has index: "+list.searchValue(33));
            });
            one.start();
            two.start();
            Thread.sleep(3000);
    }
}