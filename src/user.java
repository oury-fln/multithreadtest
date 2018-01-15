public class user implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (main.class) {
                while (main.produces == 10) {
                    try {
                        main.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("get the product.");
            }

            try {
                Thread.sleep(1000 *  main.produces + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (main.class) {
                System.out.println("get over.left:" + Integer.toString(++main.produces));
                main.class.notifyAll();
            }
        }
    }
}
