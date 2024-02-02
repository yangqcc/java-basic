package basic.collection.testMap;
/**
 * 
 * ����: ��Ҫͬʱ����hashCode�Լ�equals����
 * @author yangqc
 *
 * 2016-6-14
 */
public class Groundhog2 extends Groundhog{

	public Groundhog2(int n) {
		super(n);
	}

	public int hashCode(){
		return number;
	}
	
	public boolean equals(Object obj){
		return obj instanceof Groundhog2 && (number==((Groundhog2)obj).number);
	}
}
