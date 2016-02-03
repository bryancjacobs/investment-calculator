package invest.util;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Bryan
 * Date: 6/29/14
 * Time: 11:08 PM
 */
public class DateUtil {

    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private static DateFormat dayOfWeek = new SimpleDateFormat("yyyy-MM-dd EEEE");

    public static Date toDate(String date) {
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toStr(DateTime date) {
        return dayOfWeek.format(date.toDate());

    }

    public static DateTime monthsBefore(DateTime date, int monthsBefore) {
        return new DateTime(date).minusMonths(monthsBefore);
    }

    public static DateTime weeksBefore(DateTime beforeDate, int weeks) {
        return new DateTime((beforeDate).minusWeeks(weeks));
    }

}
