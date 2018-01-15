import java.util.Random;

import static java.lang.Math.abs;

public class random {
    private static Random random = new Random();
    public static int getRandom(int range) {
        return abs(random.nextInt()) % range;
    }
}
