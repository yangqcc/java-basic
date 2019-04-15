package thinkinjava.test9;

import java.util.Arrays;

public class Apply {

  public static void process(Processor p, Object s) {
    System.out.println("Using Processor " + p.name());
    System.out.println(p.process(s));
  }

  public static String s = "Sisagreement with beliefs is by definition oncorrect";

  public static void main(String[] args) {
    process(new Upcase(), s);
    process(new Downcase(), s);
    process(new Splitter(), s);
  }
}

class Processor {

  public String name() {
    return getClass().getSimpleName();
  }

  Object process(Object input) {
    return input;
  }
}

class Upcase extends Processor {

  @Override
  String process(Object input) {
    return ((String) input).toUpperCase();
  }
}

class Downcase extends Processor {

  String process(Object input) {
    return ((String) input).toLowerCase();
  }
}

class Splitter extends Processor {

  String process(Object input) {
    return Arrays.toString(((String) input).split(" "));//���ַ�ʽ���Խ�һ���ַ�������һ���ַ�������
  }
}

class animalsss extends Apply {

}