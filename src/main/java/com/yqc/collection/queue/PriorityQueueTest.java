package com.yqc.collection.queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Apple> queue=new PriorityQueue<>();
		queue.add(new Apple(1));
		queue.add(new Apple(0));
		queue.add(new Apple(-1));
		queue.add(new Apple(11));
		queue.add(new Apple(211));
		queue.add(new Apple(321));
		queue.add(new Apple(-2));
		queue.add(new Apple(9));
		queue.add(new Apple(2));
		queue.add(new Apple(1));
		while(!queue.isEmpty()){
			System.out.println(queue.remove());
		}
	}
}

class Apple implements Comparable<Apple> {
	private Integer i;

	public Apple(Integer i) {
		this.i = i;
	}

	@Override
	public int compareTo(Apple o) {
		if (this.i < o.i) {
			return -1;
		} else if (this.i == o.i) {
			return 0;
		}
		return +1;
	}
	
	public String toString(){
		return i.toString();
	}
}