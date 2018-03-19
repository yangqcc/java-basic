package jvm.oom;

/**
 * 2018/3/18
 */
public class StackErrorMock {

    private static int index = 1;

    //超过堆栈的请求深度
    public void call() {
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
