package basic.time.calendar;

import java.util.Calendar;

/*
 * public void add(int field,int amount);���������������ֶκͶ�Ӧ��ʱ�䣬���Ե�ǰ�������в���
 * 
 * public final void set(int year,int month,int date)
 */
public class CalendarDemo1 {
	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH);
		int day=c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"��"+(month+1)+"��"+day+"��");
		
		//����ǰ�Ľ���
		c.add(Calendar.YEAR, -3);
		year=c.get(Calendar.YEAR);
		month=c.get(Calendar.MONTH);
	    day=c.get(Calendar.DAY_OF_MONTH);
	    System.out.println(year+"��"+(month+1)+"��"+day+"��");
	    
	    //������ʮ��ǰ
	    c.add(Calendar.YEAR, 5);
	    c.add(Calendar.DAY_OF_MONTH, -10);
	    year=c.get(Calendar.YEAR);
		month=c.get(Calendar.MONTH);
	    day=c.get(Calendar.DAY_OF_MONTH);
	    System.out.println(year+"��"+(month+1)+"��"+day+"��");
	    
	    
	    c.set(2011, 11,11);
	    year=c.get(Calendar.YEAR);
		month=c.get(Calendar.MONTH);
	    day=c.get(Calendar.DAY_OF_MONTH);
	    System.out.println(year+"��"+(month+1)+"��"+day+"��");
	}
}
