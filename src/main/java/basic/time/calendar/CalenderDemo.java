package basic.time.calendar;

import java.util.Calendar;

/**
 * Calendar
 *
 * public int get(int field)���ظ��������ֶε�ֵ �������е�ÿ���ֶζ��Ǿ�̬�ĳ�Ա���������Ҷ���int����
 * 2015.10.7
 *
 * @author yangqc
 */
public class CalenderDemo {

  public static void main(String[] args) {
    Calendar rightNow = Calendar.getInstance();
    //��ȡ��
    int year = rightNow.get(Calendar.YEAR);
    int month = rightNow.get(Calendar.MONTH);
    int day = rightNow.get(Calendar.DAY_OF_MONTH);
    System.out.println(year + "��" + (month + 1) + "��" + day + "��");
  }
}
