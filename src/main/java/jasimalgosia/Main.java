package jasimalgosia;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread jas = new Thread(new Jas());
        Thread malgosia = new Thread(new Malgosia());

        jas.start();
        malgosia.start();

//        SAD :((((
//        while (jas.isAlive() || malgosia.isAlive()) {
//            Thread.sleep(1000);
//        }
//        System.out.println("Koniec dnia!");

        jas.join();
        malgosia.join();
        System.out.println("Koniec dnia!");
    }
}
