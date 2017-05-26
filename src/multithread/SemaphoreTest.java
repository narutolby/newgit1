package multithread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author boyang.lby
 * @date 5/25/17
 * @description
 */
public class SemaphoreTest {

    public static void main(String[]args){
        final Semaphore semaphore = new Semaphore(5,true);
        CyclicBarrier barrier = new CyclicBarrier(5);
        barrier.reset();
        String a = "ab";
        a.substring(0);

        for(int i=0;i<8;i++){
            final int tmp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tmp);
                }
            }).start();
        }
    }


}
