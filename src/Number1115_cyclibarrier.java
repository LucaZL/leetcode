import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Number1115_cyclibarrier {
    private int n;

    public Number1115_cyclibarrier(int n) {
        this.n = n;
    }

    CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("finished");
        }
    });
    volatile int order = 1;

    public void foo(Runnable printFoo) throws InterruptedException {
        for(int i=0;i<n;i++) {
            printFoo.run();
            try{
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for(int i=0;i<n;i++) {
            printBar.run();
            try{
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void ttt(Runnable printTTT) throws InterruptedException {
        for(int i=0;i<n;i++) {
            printTTT.run();
            try{
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Number1115_cyclibarrier n = new Number1115_cyclibarrier(6);
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

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    n.foo(() -> {
                        System.out.print("ttt");
                    });
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
