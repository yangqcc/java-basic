package basic.innerclass;

/*
 * ��ʽ���
 *   ÿ�ε��÷�����󣬷��ص���һ������
 */
public class StudentTest {

  public static void main(String[] args) {
    StudentDemo sd = new StudentDemo();
//		Student2 s=sd.getStudent();
//		s.study();
    //ע��,���������ʽ���
    sd.getStudent().study();
  }
}

class Student2 {

  public void study() {
    System.out.println("Good Good Study,Day Day Up!");
  }
}

class StudentDemo {

  public Student2 getStudent() {
    return new Student2();
  }
}