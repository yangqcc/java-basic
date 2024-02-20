package basic.thread.volatiletest;

/**
 * <p>title: volatile线程可见性</p>
 * <p>description:
 * 可见性问题：
 * （1）指令重排
 * （2）高速缓存
 * <p>
 * 先去访问工作内存，再去访问主内存，工作线程修改内容后，什么时候刷新到工作内存，
 * 什么时候又刷新到工作缓存。
 * 线程将主内存数据缓存到工作内存里面
 * #LOCK指令，会将工作内存刷新到主内存，并更新其他线程工作内存的数据
 * <p>
 * volatile通过内存屏障保证可见性
 * 内存屏障->防止指令重排
 * </p>
 *
 * @author yangqc
 * @date Created in 2019-05-06
 * @modified By yangqc
 */
public class Demo1 {

    public static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println("i=" + i);
        });

        t1.start();
        Thread.sleep(1000);
        stop = true;
    }

}
