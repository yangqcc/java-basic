package basic.time.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换
 *
 * @author yangqc
 */
public class DateUtil {

  private DateUtil() {
  }

  public static String dateToString(Date d, String format) {
    return new SimpleDateFormat(format).format(d);
  }

  /**
   * @param date 字符串类型时间
   * @param format 日期格式
   * @return Date类型时间
   */
  public static Date stringToDate(String date, String format) throws ParseException {
    return new SimpleDateFormat(format).parse(date);
  }
}
