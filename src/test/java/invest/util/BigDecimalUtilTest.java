package invest.util;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by bryan.jacobs
 * on 8/25/14.
 */
public class BigDecimalUtilTest {

    @Test
    public void newBigDecimal() {
        double expected = 2.255;
        BigDecimal bigDecimal = BigDecimalUtil.newBigDecimal(expected);

        assertEquals(bigDecimal.scale(), 2);
        assertEquals(bigDecimal.toString(), "2.26");
    }
}
