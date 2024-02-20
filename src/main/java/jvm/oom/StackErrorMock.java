package jvm.oom;

/**
 * 2018/3/18
 *
 * @author yangqc
 */
public class StackErrorMock {

    private static int index = 1;

    /**
     * 超过堆栈的请求深度
     */
    private void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        } catch (Throwable e) {
            System.out.println("Stack deep : " + index);
            e.printStackTrace();
        }
    }
}
