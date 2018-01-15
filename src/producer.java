public class producer implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (main.class) {
                while (main.produces == 0) {
                    try {
                        main.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("produce the product.");
            }
            try {
                Thread.sleep(1000 * (10 - main.produces + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (main.class) {
                System.out.println("produce over. left:" + Integer.toString(--main.produces));
                main.class.notifyAll();
            }
        }
    }
}
