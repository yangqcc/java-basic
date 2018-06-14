package basic.collection.map;

/**
 * Object��ɢ�����ǰ���ַ���ɵ�
 *
 * @author yangqc
 * 2016.6.14
 */
public class Groundhog {
    protected int number;

    public Groundhog(int n) {
        number = n;
    }

    @Override
    public String toString() {
        return "Groundhog #" + number;
    }
}
