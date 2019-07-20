package liczbypierwsze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner scan = new Scanner(new File("src/main/resources/numbers.txt"));
        ExecutorService threadPool = Executors.newFixedThreadPool(8);

        final AtomicInteger liczbPierwszych = new AtomicInteger(0);

        long startTime = System.nanoTime();
        //long startTime = System.currentTimeMillis();
        while (scan.hasNextInt()) {
            final int prime = scan.nextInt();
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    if (isPrime(prime)) {
                        liczbPierwszych.incrementAndGet();
                    }
                }
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
        double elapsedTime = (System.nanoTime() - startTime) / Math.pow(10, 9);
        //long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.printf("Ilość liczb pierwszych: %d, zajelo to: %f sekund", liczbPierwszych.get(), elapsedTime);
    }

    private static boolean isPrime(long liczba) {
        if (liczba < 2) {
            return false;
        }
        //for (int i = 2; i < Math.sqrt(liczba); i++) {
        for (int i = 2; i < liczba; i++) {
            if (liczba % i == 0) {
                return false;
            }
        }
        return true;
    }
}
