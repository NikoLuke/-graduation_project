package labwork1;

class Laws implements InitialData {

    private static double genE() {
        return Math.random();
    }

    static int[] rndMain(int T) {
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

}
