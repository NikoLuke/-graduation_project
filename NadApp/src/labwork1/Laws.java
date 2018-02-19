package labwork1;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Laws implements InitialData {

    static double genE() {
        return Math.random();
    }

    static int[] rndExp(int T) {
        double dt = T / 12;
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
            t = t % T;
            for (int j = 0; j < 12; j++) {
                if (t >= array[j] && t <= array[j+1]) {
                    count[j] = count[j] + 1;
                    break;
                }
            }
        }
        return count;
    }

    static int[] getReplacementElements() {
        int[] t = new int[12];
            for (int i = 0; i < 12; i++) {
                t[i] = (int) (genE() * 100);
            }
        return t;
    }




    private static int genM() {
        return (int) (3800 + (Math.random() * 400));
    }

    static int[] rndRel(int T) {
        double dt = T / 12;
        double[] array = new double[13];
        int k = 0;
        for (double i = 0; i <= T; i = i + dt) {
            array[k] = i;
            k++;
        }
        int[] count = new int[12];
        double t;
        int a = genM();
        for (int i = 0; i < 100; i++) {
            double newE = new BigDecimal(genE()).setScale(3, RoundingMode.HALF_UP).doubleValue();
            t = a * Math.sqrt(-2 * Math.log(newE));
            t = t % T;
            for (int j = 0; j < 12; j++) {
                if (t >= array[j] && t <= array[j+1]) {
                    count[j] = count[j] + 1;
                    break;
                }
            }
        }
        return count;
    }

}
