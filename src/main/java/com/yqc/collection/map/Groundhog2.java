package com.yqc.collection.map;
/**
 * 
 * 内容: 需要同时覆盖hashCode以及equals方法
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
