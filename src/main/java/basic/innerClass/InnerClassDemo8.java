package basic.innerClass;

/*
 * �����ڲ���������
 *   ����Ҫ�󣬲�ȫ����
 *   interface Inter{ void show();}
 *   class Outer{//�������
 *      public static void main(String[] args){
 *          Outer.method().show();
 *        }
 *    }
 *   Ҫ�����̨�����Hello World��;
 */
interface Interr {
	void show();
}

class Outer8 {
	public static Interr method() {
		// �������--��������
		return new Interr() {
			public void show() {
				System.out.println("Hello World!");
			}
		};
	}
}

public class InnerClassDemo8 {
	public static void main(String[] args) {
		Outer8.method().show();
	}
	/*
	 * 1.method()Ӧ����Outer8�еľ�̬���� 2.Outer.method().show() ���Կ�����������ķ���ֵ��һ������
	 * �����ڽӿ�Interֻ�ܹ���һ��show����������method�����ķ���ֵ������һ�� �ӿ�
	 */
}
