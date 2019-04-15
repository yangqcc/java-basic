package basic.time.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڸ�ʽ��
 * Date----String
 *   public final String format(Date date)
 *
 * String---Date
 *
 * DateFormat���Խ������ں��ַ����ĸ�ʽ���ͽ���
 *
 * SimpleDateFormat���췽��
 *
 * SimpleDateFormat()Ĭ��ģʽ
 * SimpleDateFormat(String pattern)����ģʽ
 *
 * 2015.10.7
 * @author yangqc
 */
public class DateDemo3 {

  public static void main(String[] args) throws ParseException {
    //����Date
    Date d = new Date();
    //SimpleDateFormat sdf=new SimpleDateFormat();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
    String s = sdf.format(d);
    System.out.println(s);

    String str = "2008-08-08 12:12:12";
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = sdf2.parse(str);
    System.out.println("date:" + date);
  }
}
