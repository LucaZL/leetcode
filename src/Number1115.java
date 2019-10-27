import java.util.concurrent.Semaphore;

public class Number1115 {
    private int n;
    private Semaphore semaphoreFoo;
    private Semaphore semaphoreBar;

    public Number1115(int n) {
        this.n = n;
        this.semaphoreFoo = new Semaphore(1);
        this.semaphoreBar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreFoo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphoreBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphoreFoo.release();
        }
    }

    public static void main(String[] args) {
        Number1115 n = new Number1115(6);
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
