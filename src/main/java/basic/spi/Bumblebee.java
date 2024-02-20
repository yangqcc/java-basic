package basic.spi;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-07-30
 * @modified By yangqc
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello,I am Bumblebee.");
    }
}
