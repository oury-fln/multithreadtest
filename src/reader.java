public class reader implements Runnable {
    private int no;
    public reader(int no) {
        this.no = no;
    }
    @Override
    public void run() {
        synchronized (main.class) {
            System.out.print("Reader ");
            System.out.print(no);
            System.out.println(" comes!");
            while (main.isWriting)
                try {
                    main.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            if (main.readers++ == 0)
                main.isReading = true;
            System.out.print("Reader ");
            System.out.print(no);
            System.out.println(" is writing!");
        }
        try {
            Thread.sleep(random.getRandom(4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (main.class) {
        //int range = ;
        //for (int i = 0; i < range; i++) ;
            System.out.print("Reader ");
            System.out.print(no);
            System.out.println(" has read over!");
            if (--main.readers == 0)
                    main.isReading = false;
            main.class.notifyAll();
            System.out.println("I m still alive!!!");
        }
    }
}
