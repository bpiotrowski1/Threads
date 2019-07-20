package liczbypierwsze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File plik = new File("src\\main\\resources\\numbers.txt");
        Scanner scan = new Scanner(plik);
        int liczbPierwszych = 0;
        long startTime = System.nanoTime();

        while (scan.hasNextLine()) {
            if (isPrime(scan.nextInt())) {
                liczbPierwszych++;
            }
        }
        double elapsedTime = System.nanoTime() - startTime / Math.pow(10, 9);

        System.out.println("Ilość liczb pierwszych: " + liczbPierwszych + " zajelo to: " + elapsedTime + " sekund");
    }

    public static boolean isPrime(long liczba) {
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
