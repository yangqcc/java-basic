package basic.collection.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * �ü��ϴ洢5��ѧ�����󣬲���ѧ��������б���
 * <p>
 * <p>
 * 2015.10.8
 *
 * @author yangqc
 */
public class CollectionDemo3 {

  public static void main(String[] args) {
    Collection<Student> c = new ArrayList<>();
    Student s1 = new Student("期成", 1);
    Student s2 = new Student("诗佳", 2);
    Student s3 = new Student("超超", 3);
    Student s4 = new Student("潘杰", 4);
    Student s5 = new Student("丹丹", 5);
    c.add(s1);
    c.add(s2);
    c.add(s3);
    c.add(s4);
    c.add(s5);
    //容器转化为数组
    Object[] stus = c.toArray();
    for (int i = 0; i < stus.length; i++) {
      System.out.println(((Student) stus[i]).getName());
    }

    //遍历
    Iterator ita = c.iterator();
    while (ita.hasNext()) {
      Student s = (Student) ita.next();
      System.out.println(s.getAge() + "---" + s.getName());
    }
  }
}
