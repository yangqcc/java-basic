package basic.math.SystemTest;
/*
 * system���ܱ�ʵ����,���Ǿ�̬����
 * 
 * ����:
 * public static void gc()  ����������
 * public static void exit(int status)
 * public static long currentTimeMillis
 * 
 */
public class SystemDemo {
	public static void main(String[] args) {
		Person p=new Person("�ڳ�",60);
		System.out.println(p);
		p=null;
		System.gc();
	}
}
