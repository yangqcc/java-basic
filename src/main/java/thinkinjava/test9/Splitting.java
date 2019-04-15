package thinkinjava.test9;
/**
 * ����������ʽ
 */

import java.util.Arrays;

public class Splitting {

  public static String knights = "Then, when you have found the" +
      " shrubbery, you must " + "cut down the mightiest tree in the" +
      "forest... " + "with... a herring!";
  public static String s1 = "Java now has regular expressions";

  public static void split(String expression, String regex) {
    System.out.println(Arrays.toString(expression.split(regex)));
  }

  public static void main(String[] args) {
    split(knights, " ");//�Կո��������ַ�
    split(knights, "\\W+");//�Էǵ����ַ����֣������ɾ����
    split(knights, "n\\W+");//��ĸn�������һ�������ǵ����ַ�
    split(s1, "^Java");
    split(s1, "s?");
    split(s1, "s+");
    split(s1, "s*\"d");
  }
}