package basic.time.date;

import java.util.Date;

/*
 * Date �ض�˲�䣬��ȷ������
 *
 * ���췽��
 *
 * Date()���ݵ�ǰĬ�Ϻ���֮�������ڶ���
 *
 * Date(long date)  ���������ĺ���ֵ�������ڶ���
 * ����Date���󲢳�ʼ���˶����Դ˱�ʾ�Դӱ�׼��׼ʱ�䣬��1970��1��1������ָ���ĺ���ֵ
 * 2015.10.6
 */
public class DateDemo1 {

  public static void main(String[] args) {
    //
    Date d = new Date();
    System.out.println(d.toString());

    //long time=System.currentTimeMillis();
    long time = 30000;
    Date d2 = new Date(time);
    System.out.println(d2);
  }
}
