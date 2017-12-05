package labwork1;

public class Laws {

    public static double genE() {
        return Math.random();
    }

    public static int[] rndMain() {
        double T = 11000;
        double dt = T/12;
        double[] array = new double[13];
        int k = 0;
        for (double i = 0; i <= T; i = i + dt) {
            array[k] = i;
            k++;
        }
        int[] count = new int[12];
        double t;
        for (int i = 0; i < 100; i++) {
            t = - (1 / 0.0003) * Math.log(genE());
            t = t % 11000;
            for (int j = 0; j < 12; j++) {
                if (j==12) break;
                if (t >= array[j] && t <= array[j+1]) {
                    count[j] = count[j] + 1;
                    break;
                }
            }
        }
        return count;
    }

    public static String[] getString() {
        int[] value = rndMain();
        String[] string = new String[12];
        for (int i = 0; i < 12; i++) {
            string[i] = String.valueOf(value[i]);
        }
        return string;
    }

}
