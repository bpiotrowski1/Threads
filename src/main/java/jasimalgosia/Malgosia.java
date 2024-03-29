package jasimalgosia;

import java.util.concurrent.CountDownLatch;

public class Malgosia implements Runnable {
    private CountDownLatch latch;

    Malgosia(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Maglosia biega...");
            Thread.sleep(6000);
            System.out.println("Malgosia skonczyla biegac\nMalgosia bierze prysznic...");
            Thread.sleep(2000);
            System.out.println("Malgosia skonczyla brac prysznic\nMalgosia je sniadanie...");
            Thread.sleep(1000);
            System.out.println("Malgosia zjadla sniadanie\nMalgosia sie ubiera...");
            Thread.sleep(1000);
            System.out.println("Malgosia ubrala sie\nMalgosia spotyka sie z kolezanka...");
            Thread.sleep(25000);
            System.out.println("Malgosia spotkala sie z kolezanka");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
