package basic.innerClass;
/*
 * ���󣺷���Inner���show()����
 * Inner�ǳ�Ա�ڲ���
 * �ⲿ��.�ڲ����� ������=�ⲿ�����.�ڲ������
 */
public class Test1 {
	public static void main(String[] args) {
		Outer.Inner in=new Outer().new Inner();
		in.show();
	}
}

class Outer {
	private int num = 10;

	class Inner {
		public void show() {
			System.out.println(num);
		}
	}
}