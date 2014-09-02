package invest.util;

import org.junit.Test;

import java.math.BigDecimal;

import static invest.util.BigDecimalUtil.percentageChange;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by bryan.jacobs
 * on 8/25/14.
 */
public class BigDecimalUtilTest {

    @Test
    public void shouldGetNewBigDecimal() {
        double expected = 2.255;
        BigDecimal bigDecimal = BigDecimalUtil.newBigDecimal(expected);

        assertEquals(bigDecimal.scale(), 2);
        assertEquals(bigDecimal.toString(), "2.26");
    }

    @Test
    public void shouldGetPercentageChange() {
        BigDecimal change = percentageChange(2.0, 1.0);
        assertThat(change.doubleValue(), is(100.0));
    }
}
