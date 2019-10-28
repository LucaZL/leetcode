import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Number1116 {
    private int n;

    private Semaphore semaphoreZero = new Semaphore(1);
    private Semaphore semaphoreTemp = new Semaphore(0);
    private Semaphore semaphoreEven = new Semaphore(0);
    private Semaphore semaphoreOdd = new Semaphore(1);

    public Number1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            semaphoreTemp.release();
//            if(i%2==0) {
//                semaphoreOdd.release();
//            }else{
//                semaphoreEven.release();
//            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2) {
            semaphoreEven.acquire();
            semaphoreTemp.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
            semaphoreOdd.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2) {
            semaphoreOdd.acquire();
            semaphoreTemp.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
            semaphoreEven.release();
        }
    }

    public static void main(String[] args) {
        Number1116 n = new Number1116(10);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                IntConsumer intConsumer = s -> System.out.print(s);
                try {
                    n.zero(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                IntConsumer intConsumer = s -> System.out.print(s);
                try {
                    n.even(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                IntConsumer intConsumer = s -> System.out.print(s);
                try {
                    n.odd(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
