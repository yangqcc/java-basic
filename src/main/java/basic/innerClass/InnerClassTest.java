package basic.innerClass;
/*
 * ������:
 *    Ҫ������շֱ����30,20,10.
 *    ע�⣺�ڲ�����ⲿ��û�м̳й�ϵ
 */
public class InnerClassTest {
	public static void main(String[] args) {
		Outerr.Inner oi=new Outerr().new Inner();
		oi.show();
	}
} 
class Outerr{
	public int num=10;
	class Inner{
		public int num=20;
		public void show(){
			int num=30;
			System.out.println(num);
			System.out.println(this.num);
//			System.out.println(new Outerr().num);
			System.out.println(Outerr.this.num);//ע�⡣������Ҫ��ͨ���ⲿ�����޶�this����
		}
	}
}