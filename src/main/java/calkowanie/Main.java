package calkowanie;

import com.google.common.util.concurrent.AtomicDouble;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int xp = 0;
    private static final int xk = 15;
    private static final double n = 10000000;
    private static final double dx = (xk - xp) / n;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
        System.out.println("Calka = " + calkuj(xp, n, dx));
        System.out.println("Liczenie zajelo: " + (System.nanoTime() - startTime) / Math.pow(10, 9));

        startTime = System.nanoTime();
        System.out.println("Calka liczona wielowatkowo = " + calkujWielowatkowo().get());
        System.out.println("Liczenie zajelo: " + (System.nanoTime() - startTime) / Math.pow(10, 9));
    }

    private static AtomicDouble calkujWielowatkowo() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        final AtomicDouble calka = new AtomicDouble(0.0);

        for (int i = 0; i < 15; i++) {
            final double startPrzedzialu = xp + i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    double malaCalka = calkuj(startPrzedzialu, n / 15, dx / 3);
                    calka.getAndAdd(malaCalka);
                }
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);

        calka.set(calka.get() * dx);
        return calka;
    }

    private static double calkuj(double startX, double prosotkatow, double szerokosc) {
        double calka = 0;

        for (int i = 1; i <= prosotkatow; i++) {
            calka += function(startX + i * szerokosc);
        }
        calka *= szerokosc;

        return calka;
    }

    private static double function(double x) {
        return (3 * Math.sin(x)) - (0.2 * Math.pow(x, 3)) + (3 * Math.pow(x, 2));
    }
}
