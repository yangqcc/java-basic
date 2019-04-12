package basic.io.studentdemo;

import java.util.Comparator;
import java.util.TreeSet;

public class studentDemo {
	public static void main(String[] args) {
		TreeSet<Student> ts=new TreeSet<Student>(new Comparator<Student>(){

			@Override
			public int compare(Student s1, Student s2) {
				int num=s2.getSum()-s1.getSum();
				int num2=num==0?s1.getChinese():s2.getChinese();
				return 0;
			}
			
		});
		
	}
}
