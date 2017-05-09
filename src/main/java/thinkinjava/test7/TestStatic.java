package thinkinjava.test7;

public class TestStatic {
	public static int a=12;
	public final Student stu=new Student("Â½êÀ");
	public final static int c=14;
	public static void main(String[] args) {
		TestStatic test=new TestStatic();
		TestStatic test1=new TestStatic();
		TestStatic test2=new TestStatic();
		test.a=15;
		Student stu=test1.stu;
		stu.setName("³¬³¬");
		test.stu.showName();
		Student stu1=test2.stu;
		stu1.setName("ÆÚ³É");
		test2.stu.showName();
		System.out.println(test1.a);
	}
}
class Student{
	private String name;
	public void setName(String name){
		this.name=name;
	}
	public void showName(){
		System.out.println(name);
	}
	public Student(String name){
		this.name=name;
		System.out.println("hello "+name);
	}
}
