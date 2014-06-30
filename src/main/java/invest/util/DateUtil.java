package invest.util;

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

    public static String toStr(Date date) {
        return dayOfWeek.format(date);

    }

}
