package basic.thread.threadlocal.sessiontest;

/**
 * <p>title:</p>
 * <p>description:</p>
 *
 * @author yangqc
 * @date Created in 2019-05-08
 * @modified By yangqc
 */
class MySession {

    private int id;
    private String name;

    public MySession(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MySession() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MySession{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
