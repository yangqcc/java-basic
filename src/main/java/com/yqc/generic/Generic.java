package com.yqc.generic;

import java.io.Serializable;

public class Generic<T> {
	private T a;

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}
}
class Dog extends Generic<Dog> implements Serializable{
}
class Cat extends Generic<Cat> implements Serializable{
}
class Animal extends Generic<Integer>{
}