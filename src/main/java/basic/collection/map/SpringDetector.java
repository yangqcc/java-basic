package basic.collection.map;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * ����:
 *
 * @author yangqc
 * <p>
 * 2016-6-14
 */
public class SpringDetector {

  public static <T extends Groundhog> void detectSpring(Class<T> type)
      throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Constructor<T> ghog = type.getConstructor(int.class);
    Map<Groundhog, Prediction> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      map.put(ghog.newInstance(i), new Prediction());
    }
    System.out.println("map=" + map);
    Groundhog gh = ghog.newInstance(3);
    System.out.println("Looking up prediction for " + gh);
    //��û���ҵ�Groundhog#3��Ӧ��ֵ����Ϊ����ʹ�õ���Object�̳ж�����ɢ����
    if (map.containsKey(gh)) {
      System.out.println(map.get(gh));
    } else {
      System.out.println("Key not found:" + gh);
    }
  }

  public static void main(String[] args)
      throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    detectSpring(Groundhog.class);
  }
}
