package basic.thread;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {

  public static void main(String[] args) {
    LongAdder longAdder = new LongAdder();
    longAdder.add(10);
  }
}
