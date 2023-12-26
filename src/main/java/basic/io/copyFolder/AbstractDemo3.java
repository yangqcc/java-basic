package basic.io.copyFolder;

abstract class Employee{
	private String name;
	private String id;
	private int salary;
	
	public Employee(){}
	public Employee(String name,String id,int salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	
	public void setSalary(int salary){
		this.salary = salary;
	}
	public int getSalary(){
		return salary;
	}
	
	public abstract void work();
}
class Staff extends Employee{
	public Staff(){}
	public Staff(String name,String id,int salary){
		super(name,id,salary);
	}
	
	public void work(){
		System.out.println("�ô���");
	}
}
class Leader extends Employee{
	private int bonus;//���붨���Ա����
	public Leader(){}
	public Leader(String name,String id,int salary,int bonus){
		super(name,id,salary);
		this.bonus =bonus;
	}
	
	public void work(){
		System.out.println("�����");
	}
	
	public int getBonus(){
		return bonus;
	}
	public void setBonus(){
		this.bonus = bonus;
	} 
}

class AbstractDemo3{
	public static void main(String[] args){
		Employee a = new Staff();
		a.setName("С��");
		a.setId("007");
		a.setSalary(8000);
		System.out.println(a.getName()+"--------"+a.getId()+"-----------"+a.getSalary());
		a.work();
		System.out.println("-------------------");
		a = new Staff("С��","007",8000);
		System.out.println(a.getName()+"--------"+a.getId()+"-----------"+a.getSalary());
		System.out.println("-------------------");
		//�������������Լ����е�����ʱ��Ӧ������̬����ʵ�⡣
		Leader b = new Leader();
		b = new Leader("Сǿ","001",12000,2000);
		System.out.println(b.getName()+"--------"+b.getId()+"-----------"+b.getSalary()+"------"+b.getBonus());
		b.work();
		
	}
}