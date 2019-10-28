import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Number1117 {

    private CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            semaphoreH.release(2);
            semaphoreO.release();
//            System.out.println();
        }
    });

    private Semaphore semaphoreH;
    private Semaphore semaphoreO;

    public Number1117() {
        semaphoreH = new Semaphore(2);
        semaphoreO = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Number1117 n = new Number1117();
        String input = "OOHHHH";
        for(char c: input.toCharArray()) {
            if(c == 'H') {
                Thread t1 = new Thread(() -> {
                    try {
                        n.hydrogen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.print("H");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                t1.start();
            }else{
                Thread t2 = new Thread(() -> {
                    try {
                        n.oxygen(new Runnable() {
                            @Override
                            public void run() {
                                System.out.print("O");
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                t2.start();
            }
        }
    }
}
