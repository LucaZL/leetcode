import java.util.concurrent.CountDownLatch;

public class Number1114 {
    private CountDownLatch countDownLatchFirst;
    private CountDownLatch countDownLatchSecond;

    public Number1114() {
        countDownLatchFirst = new CountDownLatch(1);
        countDownLatchSecond = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatchFirst.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatchFirst.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatchSecond.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatchSecond.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        Number1114 number1114 = new Number1114();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    number1114.first(() -> {
                        System.out.println(1);
                    });
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    number1114.second(() -> {
                        System.out.println(2);
                    });
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    number1114.third(() -> {
                        System.out.println(3);
                    });
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t3.start();
        t2.start();
        t1.start();
    }
}
