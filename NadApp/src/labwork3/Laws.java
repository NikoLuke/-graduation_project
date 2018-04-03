package labwork3;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Laws {

    private double genE() { return Math.random(); }

    private double genY() { return (-1 + (Math.random() * 2)); }

    double Exponential(double lambda) {
        return -( 1 / lambda ) * Math.log(genE());
    }

    double Normal(int alpha, int sigma) {
        return alpha + sigma * genY();
    }

    double Rayleigh(int sigma) {
        double newE = new BigDecimal(genE()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        return sigma * Math.sqrt(-2 * Math.log(newE));
    }

}
