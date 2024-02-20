package basic.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * <p>title: ArrayList和LinkedList的区别</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-04-08
 * @modified By yangqc
 */
public class ListTest {

  /**
   * 1. 是否保证线程安全： ArrayList 和 LinkedList 都是不同步的，也就是不保证线程安全；
   *
   * 2. 底层数据结构： ArrayList 底层使用的是Object数组；LinkedList 底层使用的是双向链表数据结构（JDK1.6之前为循环链表，JDK1.7取消了循环。注意双向链表和双向循环链表的区别：）；
   * 详细可阅读 https://www.cnblogs.com/xingele0917/p/3696593.html 循环链表优化
   *
   * 3. 插入和删除是否受元素位置的影响： ① ArrayList 采用数组存储，所以插入和删除元素的时间复杂度受元素位置的影响。 比如：执行add(E e) 方法的时候， ArrayList
   * 会默认在将指定的元素追加到此列表的末尾， 这种情况时间复杂度就是O(1)。但是如果要在指定位置 i 插入和删除元素的话（add(int index, E element) ）时间复杂度就为
   * O(n-i)。 因为在进行上述操作的时候集合中第 i 和第 i 个元素之后的(n-i)个元素都要执行向后位/向前移一位的操作。 ② LinkedList
   * 采用链表存储，所以插入，删除元素时间复杂度不受元素位置的影响，都是近似 O（1）而数组为近似 O（n）。
   *
   * 4. 是否支持快速随机访问： LinkedList 不支持高效的随机元素访问，而 ArrayList 支持。快速随机访问就是通过元素的序号快速获取元素对象(对应于get(int index)
   * 方法)。
   *
   * 5. 内存空间占用： ArrayList的空 间浪费主要体现在在list列表的结尾会预留一定的容量空间， 而LinkedList的空间花费则体现在它的每一个元素都需要消耗比ArrayList更多的空间（因为要存放直接后继和直接前驱以及数据）。
   *
   * 6.补充内容:RandomAccess接口 https://www.cnblogs.com/xingele0917/p/3696593.html
   */

  public static void main(String[] args) {
    //ArrayList初始化时，初始化了一个空数组，会在添加第一个元素时扩容，容量为DEFAULT_CAPACITY=10
    List<Integer> myArrayList = new ArrayList<>(1);
    myArrayList.add(1);
    List<String> myLinkedList = new LinkedList<>();

    //Vector是线程安全的
    Vector<Integer> myVector = new Vector<>();
    myVector.add(1);

    int i = Collections.binarySearch(myArrayList, 1);
    System.out.println(i);
  }
}
