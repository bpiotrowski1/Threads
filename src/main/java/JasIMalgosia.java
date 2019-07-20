public class JasIMalgosia {
    public static void main(String[] args) throws InterruptedException {
        Thread jas = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Jas je sniadanie...");
                try {
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
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread malgosia = new Thread(new Runnable() {
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
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        jas.start();
        malgosia.start();
        while (jas.isAlive() || malgosia.isAlive()) {
            Thread.sleep(1000);
        }
        System.out.println("Koniec dnia!");
    }
}
