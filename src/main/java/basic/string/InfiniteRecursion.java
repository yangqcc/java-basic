package basic.string;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {

  public String toString() {
    return " InfiniteRecursion address: " + super.toString() + "\n";
  }

  /*
   * ��ӡ��ַ������this����,������ݹ���ã���Ӧ����Object��toString������
   * �������඼�Ǽ̳���Object�࣬������super.toString()
   *
   * public class InfiniteRecursion { public String toString(){ return
   * " InfiniteRecursion address: "+this+"\n"; }
   * ����ͻ�����ݹ���ã���Ϊ����������String����������һ��+�ţ��������
   * ������String�����Ǳ������ͽ�thisת����һ��String��ת����������ͨ�� �����toString���������Ǳ������ݹ���ã��ͻᱨ��
   */
  public static void main(String[] args) {
    List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
    for (int i = 0; i < 10; i++) {
      v.add(new InfiniteRecursion());
    }
    System.out.print(v);
  }
}
