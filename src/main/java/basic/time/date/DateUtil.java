package basic.time.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * ���ں��ַ����໥ת���Ĺ�����
 */
public class DateUtil {

  private DateUtil() {
  }

  ;

  public static String dateToString(Date d, String format) {
//		SimpleDateFormat sdf=new SimpleDateFormat(format);
    return new SimpleDateFormat(format).format(d);
  }

  /**
   * @param date ���������ַ���
   * @param format ���ݹ�����Ҫ��ת���ĸ�ʽ
   * @return ����������ڶ���
   */
  public static Date stringToDate(String date, String format) throws ParseException {
    return new SimpleDateFormat(format).parse(date);
  }
}
