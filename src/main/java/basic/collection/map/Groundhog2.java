package basic.collection.map;

/**
 * ����: ��Ҫͬʱ����hashCode�Լ�equals����
 *
 * @author yangqc
 * <p>
 * 2016-6-14
 */
public class Groundhog2 extends Groundhog {

  public Groundhog2(int n) {
    super(n);
  }

  @Override
  public int hashCode() {
    return number;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Groundhog2 && (number == ((Groundhog2) obj).number);
  }
}
