public class main implements Runnable {
    private int no;
    private static final int j = 3;
    //public static Object reader = new Object();
    //public static Object producer = new Object();
    //public static Object user = new Object();
    public static boolean isReading = false;
    public static boolean isWriting = false;
    public static int readers = 0;
    public static int produces = 10;
    public static Object mutex = new Object();
    public main(int i) {
        this.no = i;
    }
    @Override
    public void run() {
        synchronized (main.class){
            if (no < j) {
                try {
                    System.out.print(no);
                    System.out.print(" sleeps!");
                    main.class.wait();
                    System.out.print(no);
                    System.out.print(" wakes up!");
                    //main.class.notifyAll();
                    //while (true) ;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                main.class.notifyAll();
               // while (true) ;
            }
        }
    }

    static public void main(String[] args) {
        /*int reader = 0, writer = 0;
        for (int i = 0; i < 10; i++) {
            if (random.getRandom(2) == 0) {
                new Thread(new reader(reader++)).start();
            } else {
                new Thread(new writer(writer++)).start();
            }
        }*/
        new Thread(new user()).start();
        new Thread(new producer()).start();
    }
}
