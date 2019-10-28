import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Number1115_lock {
    private int n;
    private Lock lock = new ReentrantLock(true);
    volatile boolean perm = true;

    public Number1115_lock(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if(perm) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    i++;
                    perm = false;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try{
                if(!perm) {
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    i++;
                    perm = true;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Number1115_lock n = new Number1115_lock(6);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.foo(() -> {
                        System.out.print("foo");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    n.bar(() -> {
                        System.out.print("bar");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
