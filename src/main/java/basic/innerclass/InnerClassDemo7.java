package basic.innerClass;
/*
 * �����ڲ��࿪����ʹ��
 *  �׶�:ֻ��ʹ��һ��
 */
public class InnerClassDemo7 {
	public static void main(String[] args) {
		PersonDemo pd=new PersonDemo();
		pd.method(new Person(){
			public void study(){
				System.out.println("�ú�ѧϰ����������!");
			}
		});
	}
}
interface Person{
	public abstract void study();
}
class Student implements Person{
	public void study(){
		System.out.println("�ú�ѧϰ����������");
	}
}
class PersonDemo{
	//�ӿ�����Ϊ��ʽ���� ������Ҫ�Ĳ��ǽӿڣ����Ǹ��ӿ�ʵ����Ķ���
	public void method(Person p){
		p.study();
	}
}
