public class main {
    public static boolean isReading = false;
    public static boolean isWriting = false;
    public static int readers = 0;
    public static int produces = 10;
    //public static Object mutex = new Object();

   static public void main(String[] args) {
       //reader--writer
        int reader = 0, writer = 0;
        for (int i = 0; i < 10; i++) {
            if (random.getRandom(2) == 0) {
                new Thread(new reader(reader++)).start();
            } else {
                new Thread(new writer(writer++)).start();
            }
        }
        //new Thread(new user()).start();
        //new Thread(new producer()).start();
    }
}
