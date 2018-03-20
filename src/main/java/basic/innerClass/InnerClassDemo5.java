package basic.innerClass;

/*
 * �ֲ��ڲ���
 *   A:����ֱ�ӷ����ⲿ��ĳ�Ա
 *   B:���Դ����ڲ���Ķ���ͨ����������ڲ���ķ�������ʹ�þֲ��ڲ���Ĺ���
 *
 *   �����⣬�ֲ��ڲ�����ʾֲ�������ע������?
 *     �ֲ��ڲ�����ʾֲ�����������final����
 */
public class InnerClassDemo5 {
    public static void main(String[] args) {
        Outer3 o = new Outer3();
        o.method();
    }
}

class Outer3 {
    private int num = 10;

    public void method() {
        final int num2 = 20;
        class Inner {
            public void show() {
                //���ڲ����з��ʱ��ر���num2����Ҫ������Ϊ��������final
                System.out.println(num2);
                System.out.println(num);
            }
        }
        Inner i = new Inner();
        i.show();
    }
}
