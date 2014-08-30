package invest.util;


import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * User: Bryan
 * Date: 6/29/14
 * Time: 11:24 PM
 */
public class DateUtilTest {

    @Test
    public void shouldGetDateWithTuesday() {

        DateTime dateTime = new DateTime(2014, 6, 3, 10, 0);
        String date = DateUtil.toStr(dateTime);
        assertTrue(date.toLowerCase().contains("tuesday"));
    }

    @Test
    public void shouldGetThreeMonthsBefore() {

        // Jan 1st 10:00 am
        DateTime date = new DateTime(2014, 4, 1, 10, 0);

        DateTime actual = DateUtil.threeMonthsBefore(date);

        int month = actual.get(DateTimeFieldType.monthOfYear());

        // test that we actually went back three months IE January
        assertTrue(month == 1);
    }

}
