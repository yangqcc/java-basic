package basic.collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>title:</p>
 * <p>description: HashMap和ConcurrentHashMap以及HashTable的区别</p>
 *
 * @author yangqc
 * @date Created in 2019-04-09
 * @modified By yangqc
 */
public class MapTest {

  public static void main(String[] args) {
    HashMap<String, Integer> hashMap = new HashMap<>(2);
    Hashtable<String, Integer> hashtable = new Hashtable<>(2);
    ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>(2);
    hashMap.put("234", 12);
    hashtable.put("ddd", 2121);
    concurrentHashMap.put("321", 2121);
  }

}
