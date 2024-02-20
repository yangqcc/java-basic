package basic.thread.escape;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-04-15
 * @modified By yangqc
 */
public class EscapeAnalysis {

    private static class Foo {
        private int x;
        private static int counter;

        public Foo() {
            x = (++counter);
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 1000 * 1000 * 10; ++i) {
            Foo foo = new Foo();
        }
        long end = System.nanoTime();
        System.out.println("Time cost is " + (end - start));
    }
}
