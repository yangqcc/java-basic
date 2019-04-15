package basic.collection.queue;

import java.util.LinkedList;

/**
 * 使用LinkedList实现双向链表
 *
 * @author yangqc
 */
public class Deque<T> {

  private LinkedList<T> deque = new LinkedList<T>();

  public void addFirst(T e) {
    deque.addFirst(e);
  }

  public void addList(T e) {
    deque.addLast(e);
  }

  public T getFirst() {
    return deque.getFirst();
  }

  public T getLast() {
    return deque.getLast();
  }

  public T removeFirst() {
    return deque.removeFirst();
  }

  public T removeLast() {
    return deque.removeLast();
  }

  public int size() {
    return deque.size();
  }

  public String toString() {
    return deque.toString();
  }
}
