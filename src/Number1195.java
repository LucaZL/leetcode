import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Number1195 {
    private int n;
    private Semaphore semaphore = new Semaphore(1);
    private Semaphore semaphoreNumber = new Semaphore(0);
    private Semaphore semaphore3 = new Semaphore(0);
    private Semaphore semaphore5 = new Semaphore(0);
    private Semaphore semaphore15 = new Semaphore(0);

    volatile private int cur = 1;

    public Number1195(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            semaphore3.acquire();
            if(cur > n) break;
            printFizz.run();
            semaphoreNumber.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true) {
            semaphore5.acquire();
            if(cur > n) break;
            printBuzz.run();
            semaphoreNumber.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            semaphore15.acquire();
            if(cur > n) break;
            printFizzBuzz.run();
            semaphoreNumber.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            if(cur % 15 == 0) {
                semaphore15.release();
                semaphoreNumber.acquire();
            }else if(cur % 3 == 0) {
                semaphore3.release();
                semaphoreNumber.acquire();
            }else if(cur % 5 == 0) {
                semaphore5.release();
                semaphoreNumber.acquire();
            }else {
                printNumber.accept(cur);
            }
            cur++;
            if(cur > n) {
                semaphore3.release();
                semaphore5.release();
                semaphore15.release();
                break;
            }
        }
    }

    public static void main(String[] args) {
        Number1195 n = new Number1195(15);

        Thread f3 = new Thread(() -> {
            try {
                n.fizz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("fizz,");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread b5 = new Thread(() -> {
            try {
                n.buzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("buzz,");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread fb15 = new Thread(() -> {
            try {
                n.fizzbuzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.print("fizzbuzz,");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        IntConsumer consumer = s -> System.out.print(s+",");

        Thread number = new Thread(() -> {
            try {
                n.number(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        f3.start();
        b5.start();
        fb15.start();
        number.start();
    }
}
