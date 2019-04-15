package basic.time.calendar;

import java.util.Calendar;
import java.util.Scanner;

/*
 * ��ȡ����һ������ж�����
 * ����
 * ����¼���������
 * �������������������
 *
 *
 * 2015.10.7
 *
 */
public class CalendarDemo3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("���������:");
    int year = sc.nextInt();
    System.out.println("���������:" + getMonthDay(year) + "��");
  }

  public static int getMonthDay(int year) {
    Calendar c = Calendar.getInstance();
    c.set(year, 2, 1);
    c.add(Calendar.DATE, -1);
    return c.get(Calendar.DAY_OF_MONTH);
  }
}
