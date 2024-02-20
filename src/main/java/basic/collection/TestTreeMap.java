package basic.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author yangqc
 */
public class TestTreeMap {

  public static void main(String[] args) {
    System.out.println("/////////////下面是TreeMap////////////////");
    TreeMap<String, String> treeMap = new TreeMap<>();
    treeMap.put("yangqc", "123");
    treeMap.put("shijia", "31");
    for (Map.Entry<String, String> entry : treeMap.entrySet()) {
      System.out.println(entry.getKey() + "*" + entry.getValue());
    }

    System.out.println("/////////////下面是TreeSet////////////////");
    TreeSet<String> treeSet = new TreeSet<>();
    treeSet.add("bbc");
    treeSet.add("bad");
    for (String key : treeSet) {
      System.out.println(key);
    }

    System.out.println("/////////////下面是LinkHashMap////////////////");
    LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(1);
    linkedHashMap.put("yangqc", "123");
    linkedHashMap.put("shijia", "211");
    for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
      System.out.println(entry.getKey() + "*" + entry.getValue());
    }
  }
}
