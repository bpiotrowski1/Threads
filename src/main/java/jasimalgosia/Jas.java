package jasimalgosia;

import java.util.concurrent.CountDownLatch;

public class Jas implements Runnable{
    private CountDownLatch latch;

    Jas(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Jas je sniadanie...");
            Thread.sleep(5000);
            System.out.println("Jas zjadl sniadanie\nJas bierze prysznic...");
            Thread.sleep(3000);
            System.out.println("Jas skonczyl prysznic\nJas ubiera sie...");
            Thread.sleep(1);
            System.out.println("Jas ubral sie\nJas idzie na zakupy...");
            Thread.sleep(15000);
            System.out.println("Jas zrobil zakupy\nJas gra na konsoli...");
            Thread.sleep(5000);
            System.out.println("Jas skonczyl grac na konsoli");
            latch.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
