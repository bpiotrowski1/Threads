package liczbypierwsze;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CzyParzyste {
    public static void main(String[] args) throws InterruptedException {
        //tworzenie puli watkow
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        //dodanie zadania
//        for (int i = 0; i < 10; i++) {
//            threadPool.submit(new Runnable() {
//                @Override
//                public void run() {
//                    String threadName = Thread.currentThread().getName();
//                    System.out.println("Siema jestem " + threadName);
//                }
//            });
//        }

        final AtomicInteger liczbParzystych = new AtomicInteger(0);
        for (int i = 0; i < 100000; i++) {
            final int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    if(finalI % 2 == 0) {
                        liczbParzystych.incrementAndGet();
                    }
                }
            });
        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Liczb parzystych od 0 do 100000: " + liczbParzystych.get());
    }
}
