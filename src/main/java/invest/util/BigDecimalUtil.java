package invest.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * User: Bryan
 * Date: 8/16/14
 * Time: 11:18 PM
 */
public class BigDecimalUtil {

    public static final RoundingMode ROUND = RoundingMode.HALF_UP;
    public static final int PRECISION = 2;

    public static BigDecimal newBigDecimal(Double value) {
        return BigDecimal.valueOf(value).setScale(PRECISION, ROUND);
    }

    public static MathContext newMC() {
        return new MathContext(PRECISION, ROUND);
    }

    public static BigDecimal percentageChange(Double nextAdjusted, Double originalAdjusted) {

        BigDecimal difference = newBigDecimal(nextAdjusted).subtract(newBigDecimal(originalAdjusted), newMC());

        BigDecimal divide = difference.divide(newBigDecimal(originalAdjusted), newMC());

        return divide.multiply(newBigDecimal(100.0), newMC());;
    }

}
