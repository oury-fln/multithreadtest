public class writer implements Runnable {
    private int no;
    public writer(int no) {
        this.no = no;
    }
    @Override
    public void run() {
        synchronized (main.class) {
            System.out.print("Writer ");
            System.out.print(no);
            System.out.println(" comes!");
            while (main.isReading || main.isWriting)
                try {
                    main.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            main.isWriting = true;
            System.out.print("Writer ");
            System.out.print(no);
            System.out.println(" is writing!");
        }
        synchronized (main.class) {
            try {
                main.class.wait(random.getRandom(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //int range = ;
        //for (int i = 0; i < range; i++) ;
        //synchronized (main.class) {
            System.out.print("Writer ");
            System.out.print(no);
            System.out.println(" has write over!");
            main.isWriting = false;
            main.class.notifyAll();
        }
    }
}
