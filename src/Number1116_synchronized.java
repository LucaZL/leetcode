import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Number1116_synchronized {
    private int n;
    private boolean zero = true;
    private boolean eORo = true;

    public Number1116_synchronized(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                while(!zero) this.wait();
                printNumber.accept(0);
                zero = false;
                this.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            for(int i=2;i<=n;i+=2) {
                while(zero || eORo) this.wait();
                printNumber.accept(i);
                zero = true;
                eORo = true;
                this.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            for (int i = 1; i <= n; i += 2) {
                while(zero || !eORo) this.wait();
                printNumber.accept(i);
                zero = true;
                eORo = false;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Number1116_synchronized n = new Number1116_synchronized(12);
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
