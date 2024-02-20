package basic.thread.threadlocal.sessiontest;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-08
 * @modified By yangqc
 */
public class MySessionUtil {

    private static final ThreadLocal<MySession> threadLocal = new ThreadLocal<>();

    public static void setSession(MySession session) {
        if (session == null) {
            throw new NullPointerException("参数不能为空!");
        }
        threadLocal.set(session);
    }

    public static MySession getSession() {
        return threadLocal.get();
    }

}

