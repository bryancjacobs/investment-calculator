package invest.util;


import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * User: Bryan
 * Date: 6/29/14
 * Time: 11:24 PM
 */
public class DateUtilTest {

    @Test
    public void shouldGetDateWithTuesday() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, 5);
        c.set(Calendar.DAY_OF_MONTH, 3);
        c.set(Calendar.YEAR, 2014);

        String date = DateUtil.toStr(c.getTime());
        Assert.assertTrue(date.toLowerCase().contains("tuesday"));
    }

}
