package basic.innerClass;

/*
 * ������
 *   ����һ���ˣ��������壬���������ࣩ
 */
public class InnerClassDemo4 {
	public static void main(String[] args) {
//		Outer1.Inner oi=new Outer1().new Inner();  ����Ǵ���ģ�����̬���ε��ڲ��಻�ܱ��ⲿ�������
		//��ʽ��  �ⲿ����.�ڲ����� ������=new �ⲿ����.�ڲ�����();
		Outer1.Inner oi=new Outer1.Inner();
		oi.show();
		oi.show2();
		Outer1.Inner.show2();//show2����һ�ֵ��÷�ʽ
	}
}

//class Body {
//	private class Heart {
//		public void operator() {
//			System.out.println("�������");
//		}
//	}
//
//	public void method(){
//		if(){
//			Heart h=new Heart();
//		h.operator();
//		}
//	}
//}
class Outer1{
	private int num=10;
	private static int num2=100;
	public static class Inner{
		public void show(){
			System.out.println(num2);
		}
		public static void show2(){
			System.out.println(num2);
		}
	}
}