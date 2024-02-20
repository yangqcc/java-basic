package thinkinjava.test16;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

  public static void main(String[] args) {
    String[] s1 = {"asc", "ccs", "cscs", "asc", "ccs", "sss"};
    boolean[] b1 = new boolean[s1.length];
    List<?> list = new ArrayList<>();
    for (int i = 0; i < s1.length; i++) {
      int t;
      do {
        t = i;
      }
      while (b1[t]);//ɸѡ���ظ���Ԫ��
////			[i]=FLAVORS[t];
//			picked[t]=true;
    }
  }
}
