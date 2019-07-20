package jasimalgosia;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Thread jas = new Thread(new Jas(latch));
        Thread malgosia = new Thread(new Malgosia(latch));

        jas.start();
        malgosia.start();

        latch.await();

//        SAD :((((
//        while (jas.isAlive() || malgosia.isAlive()) {
//            Thread.sleep(1000);
//        }

//        OK
//        jas.join();
//        malgosia.join();


        System.out.println("Koniec dnia!");
    }
}
