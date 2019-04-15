package thinkinjava.test13;
/*
 * toString�ݹ����,ע�⣬�����ӡ�ڴ��ַ��Ӧ����super.toString();
 */

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {

  public String toString() {
//		return "InfiniteRecursion address:"+this+"\n";  //������ճɵݹ���ã�������ջ���
    return "InfiniteRecursion address:" + super.toString();
  }

  public static void main(String[] args) {
    List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
    for (int i = 0; i < 10; i++) {
      v.add(new InfiniteRecursion());
    }
    System.out.println(v);
  }
}
