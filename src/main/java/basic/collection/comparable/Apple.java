package basic.collection.comparable;

public class Apple implements Comparable<Apple> {

	private final int count;

	public Apple(int count) {
		this.count = count;
	}

	@Override
	public int compareTo(Apple apple) {
		return Integer.compare(apple.getCount(), count);
	}

	public int getCount() {
		return count;
	}

	public String toString() {
		return Integer.toString(getCount());
	}

	public static void main(String[] args) {
		Apple apple1 = new Apple(1);
		Apple apple2 = new Apple(2);
		System.out.println(apple1.compareTo(apple2));
	}
}
