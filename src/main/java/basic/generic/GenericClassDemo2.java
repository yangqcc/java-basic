package basic.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Vector;

/*
 * ��ȡ���Ͳ����ľ�������
 * 2015.10.21
 */
public class GenericClassDemo2 {

  public static void main(String[] args) throws NoSuchMethodException, SecurityException {
    GenericDao dao = new GenericDao();
    dao.add(new String("saa"));
    Integer i = (Integer) dao.finadById(12);
    Vector<Date> v1 = new Vector<>();
    v1.getClass();
    Method applyMethod = GenericClassDemo2.class.getMethod("applyVector", Vector.class);
    Type[] types = applyMethod.getGenericParameterTypes();
    ParameterizedType pType = (ParameterizedType) types[0];
    System.out.println(pType.getRawType());
    System.out.println(pType.getActualTypeArguments()[0]);
  }

  public static void applyVector(Vector<Date> v1) {

  }
}
