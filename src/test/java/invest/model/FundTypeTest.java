package invest.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: Bryan
 * Date: 6/29/14
 * Time: 11:48 PM
 */
public class FundTypeTest {

    @Test
    public void shouldGetFundsSepartedByCommas() {
        String actual = FundType.commaSeparated();

        Assert.assertEquals("\"FSELX\",\"YHOO\"", actual);
    }

}
