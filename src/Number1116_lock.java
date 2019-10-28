import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Number1116_lock {
    private int n;

    private Lock lock = new ReentrantLock(true);
    private Condition z_con = lock.newCondition();
    private Condition e_con = lock.newCondition();
    private Condition o_con = lock.newCondition();

    public Number1116_lock(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++) {
            try{
                lock.lock();
                printNumber.accept(0);
                if((i&1) == 0) {
                    o_con.signalAll();
                }else{
                    e_con.signalAll();
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2) {
            try{
                lock.lock();
                e_con.await();
                printNumber.accept(i);
                z_con.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2) {
            try{
                lock.lock();
                o_con.await();
                printNumber.accept(i);
                z_con.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Number1116_lock n = new Number1116_lock(2);
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
