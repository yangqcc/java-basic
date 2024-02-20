package thinkinjava.test9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestException {

  public static boolean Expression(String expression, String judgeString) {
    Pattern p = Pattern.compile(expression);
    Matcher m = p.matcher(judgeString);
    return m.matches();
  }

  public static void main(String[] args) {
    String s = "Java now has regular expressions";
    String s2 = "Arline ate eight apples and one orange while Anita hadn't any";
    String[] sss = s.toString().split(" ");
    for (int i = 0; i < sss.length; i++) {
      System.out.println(sss[i] + "*****");
      System.out.println(Expression(sss[i], "{^J}"));
    }
//		System.out.println(expression.Expression(s, "^Java"));
//		System.out.println(expression.Expression(s, "Java"));
//		System.out.println(expression.Expression(s, "\"Breg.*"));
//		System.out.println(expression.Expression(s, "s?"));
//		System.out.println(expression.Expression(s, "s+"));
//		System.out.println(expression.Expression(s, "s*"));
//		System.out.println(expression.Expression(s, "s{4}"));
//		System.out.println(expression.Expression(s, "s{1}"));
//		System.out.println(expression.Expression(s, "s{0,3}"));
//		System.out.println(expression.Expression(s2, "(?i)(^[aeiou]||(\"s+aeiou))\"w+?[aeiou]\"b"));
  }
}
