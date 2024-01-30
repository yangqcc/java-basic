package basic.collection.testList;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * �����������ڽ�������ڣ����жϳɹ��󣬼������������Ԫ�أ���������ȴ��֪�� ����в����޸��쳣 ������������Ԫ�ص�ʱ�򣬼����ǲ����޸�Ԫ�ص�
 * <p>
 * ��ν��? A:����������Ԫ�أ��������޸�Ԫ�� ʹ��listIterator,�����޸ĵ�Ԫ���Ǹ��ڸղ�Ԫ�غ���� B:���ϱ���Ԫ�أ������޸�Ԫ�� Ԫ�ؼ�������� 2015.10.9
 */

public class ListDemo2 {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    List<String> list1 = null;

    list.add("hello");
    list.add("world");
    list.add("java");
    //ע�������жϲ��ܽ���˳��
//		if(list1!=null && list1.iterator().hasNext()){
//		   System.out.println(list1.iterator().next());
//		}else{
//			System.out.println("no!");
//		}
//		Iterator it=list.iterator();
//		while(it.hasNext()){
//			String s=(String) it.next();
//			if("world".equals(s)){
//				list.add("javaee");
//			}
//			System.out.println("list:"+list);
//		}

    ListIterator lit = list.listIterator();
    while (lit.hasNext()) {
      String s = (String) lit.next();
      if ("world".endsWith(s)) {
        lit.add("javaee");
      }
    }

    for (int i = 0; i < list.size(); i++) {
      String s = list.get(i);
      if ("world".equals(s)) {
        list.add("javaee");
      }
    }
    System.out.println("list:" + list);
  }
}
