package basic.exception;

import java.io.FileReader;

public class Test3 {

  public static void main(String[] args) throws Exception {
    Father father = new Father();
    father.test1();
  }
}

//���쳣Ҳ��ռ��Դ
//�������catch
class Father {

  private Son son = null;

  public Father() {
    son = new Son();
  }

  public void test1() throws Exception {//�������׳��쳣
    try {
      son.test2();
    } catch (Exception e) {
      System.out.println("����");
      e.printStackTrace();//���������ﱻ����
    }
    System.out.println("1");
  }
}

class Son {

  public void test2() throws Exception {
    FileReader fr = null;
    System.out.println("2");
    fr = new FileReader("d:\\d.txt");
  }
}