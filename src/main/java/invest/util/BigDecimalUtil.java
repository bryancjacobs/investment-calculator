package invest.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * User: Bryan
 * Date: 8/16/14
 * Time: 11:18 PM
 */
public class BigDecimalUtil {

    public static BigDecimal create(Double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
    }

}
