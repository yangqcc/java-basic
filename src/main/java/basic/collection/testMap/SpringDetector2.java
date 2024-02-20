package basic.collection.testMap;

import java.lang.reflect.InvocationTargetException;

/**
 * @author yangqc
 */
public class SpringDetector2 {

  public static void main(String[] args)
      throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    SpringDetector.detectSpring(Groundhog2.class);
  }
}
