package other;

import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: zhaolu
 * @createDate: 2021/7/20
 */
public class NumPrinter {


    public static void main(String[] args) {
        int max = 100;
        Semaphore markA = new Semaphore(1);
        Semaphore markB = new Semaphore(0);

        Thread A = new Thread(() -> {
            for(int i= 0;i<max;i+=2) {
                try {
                    markA.acquire();
                    System.out.println(i);
                    markB.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread B = new Thread(() -> {
            for(int i= 1;i<max;i+=2) {
                try {
                    markB.acquire();
                    System.out.println(i);
                    markA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        A.start();
        B.start();
    }
}
