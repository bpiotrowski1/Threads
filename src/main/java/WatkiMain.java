public class WatkiMain {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                long i = 0;
                while (!Thread.interrupted()) {
                    i++;
                }
                System.out.println(i);
            }
        });

        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }
}
