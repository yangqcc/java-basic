package basic.innerclass;

/*
 * �����ڲ���
 *    �ڲ���ļ�д��
 *  ��ʽ:
 *    new �������߽ӿ���(){
 *      ��д����;
 *    }
 * ������ʲô��
 *   ������һ���̳��˸������ʵ���˸ýӿڵ��������������
 */
public class InnerClassDemo6 {

  public static void main(String[] args) {
    Outer5 o = new Outer5();
    o.method();
  }
}

interface Inter {

  public abstract void show();

  public abstract void show2();
}

class Outer5 {

  public void method() {
    // һ��������ʱ��
    /*
     * new Inter(){ public void show(){ System.out.println("show"); }
     * }.show();
     */
    // ����������ʱ��
		/*
		new Inter() {
			public void show() {
				System.out.println("show");
			}

			public void show2() {
				System.out.println("show2");
			}
		}.show2();
		new Inter() {
			public void show() {
				System.out.println("show");
			}
			
			public void show2() {
				System.out.println("show2");
			}
		}.show();
		*/
    //����кܶ෽�����ͺ��鷳
    //�Ľ�����
    Inter i = new Inter() {
      public void show() {
        System.out.println("show");
      }

      public void show2() {
        System.out.println("show2");
      }
    };
    i.show();
    i.show2();
  }
}
