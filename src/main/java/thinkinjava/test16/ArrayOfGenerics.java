package thinkinjava.test16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �������飬һ�㲻�ã���û����÷��������� java�����鲢û�з��� 2015.9.1
 */
public class ArrayOfGenerics {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    List<String>[] ls;
    List[] la = new List[10];
    ls = la;
    ls[0] = new ArrayList<>();
    Object[] objects = ls;
    objects[1] = new ArrayList<Integer>();
    List<BerylliumSphere>[] spheres = new List[10];
    for (int i = 0; i < spheres.length; i++) {
      spheres[i] = new ArrayList<>();
    }
    System.out.println(Arrays.toString(spheres));
  }
}
