package basic.thread.atomic;

import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-09-05
 * @modified By yangqc
 */
public class DoubleAccumulatorTest {

    public static void main(String[] args) {
        DoubleAccumulator doubleAccumulator = new DoubleAccumulator(Double::sum, 12);
        doubleAccumulator.accumulate(12);
        System.out.println(doubleAccumulator.doubleValue());
    }
}
