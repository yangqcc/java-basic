package basic.generic;

public class TestEquals {
    public static <T extends Generic<T>> void testEquals(Class<T> t) {
        if (t == Dog.class) {
            System.out.println("this is dog!");
        } else if (t == Cat.class) {
            System.out.println("this is cat!");
        }
    }

    public static <T extends Generic<T>> void testParamer(Generic<T> g) {
        System.out.println(g);
    }

    public static void main(String[] args) {
        System.out.println(Cat.class.toString());
        testEquals(Cat.class);
        testParamer(new Cat());
        testParamer(new Dog());
    }
}
