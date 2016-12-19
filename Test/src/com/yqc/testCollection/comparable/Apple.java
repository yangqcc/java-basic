package com.yqc.testCollection.comparable;

public class Apple implements Comparable<Apple> {

	private int count;

	public Apple(int count) {
		this.count = count;
	}

	@Override
	public int compareTo(Apple apple) {
		if (apple.getCount() < count) {
			return -1;
		} else if (apple.getCount() > count) {
			return 1;
		} else {
			return 0;
		}
	}

	public int getCount() {
		return count;
	}

	public String toString() {
		return new Integer(getCount()).toString();
	}

	public static void main(String[] args) {
		Apple apple1 = new Apple(1);
		Apple apple2 = new Apple(2);
		System.out.println(apple1.compareTo(apple2));
	}
}
