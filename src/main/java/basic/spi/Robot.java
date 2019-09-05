package basic.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-07-30
 * @modified By yangqc
 */
@SPI
public interface Robot {

    void sayHello();
}
