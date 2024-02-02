package basic.collection.testMap;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

  public static void main(String[] args) {
    ConcurrentHashMap<String, String> cHashMap = new ConcurrentHashMap<>(4);
    cHashMap.put("1", "2");
    cHashMap.put("2", "2");
    cHashMap.put("3", "2");
    cHashMap.put("4", "2");
    cHashMap.get("4");
    System.out.println(cHashMap);
    Iterator<Entry<String, String>> iterator = cHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    User u1 = new User("h", "1");
    User u2 = new User("h1", "2");
    User u3 = new User("h2", "3");
    User u4 = new User("h3", "4");
    User u5 = new User("h4", "5");
    User[] users = new User[]{u1, u2, u3, u4, u5};
    for (User u : users) {
      System.out.println(u);
    }
    changeArr(users);
  }

  private static void changeArr(User[] users) {
    if (users == null) {
      return;
    }
    for (User user : users) {
      System.out.println(user);
    }
  }

  private static final class User {

    private String name;
    private String age;

    public User(String name, String age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getAge() {
      return age;
    }

    public void setAge(String age) {
      this.age = age;
    }
  }
}
