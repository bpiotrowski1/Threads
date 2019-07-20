package liczbypierwsze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/main/resources/numbers.txt"));
        int liczbPierwszych = 0;

        long startTime = System.nanoTime();
        //long startTime = System.currentTimeMillis();
        while (scan.hasNextInt()) {
            if (isPrime(scan.nextInt())) {
                liczbPierwszych++;
            }
        }
        double elapsedTime = (System.nanoTime() - startTime) / Math.pow(10, 9);
        //long elapsedTime = System.currentTimeMillis() - startTime;

        System.out.printf("Ilość liczb pierwszych: %d, zajelo to: %f sekund", liczbPierwszych, elapsedTime);
    }

    private static boolean isPrime(long liczba) {
        if(liczba < 2) {
            return false;
        }
        for(int i=2; i < liczba; i++) {
            if(liczba % i == 0) {
                return false;
            }
        }
        return true;
    }
}
