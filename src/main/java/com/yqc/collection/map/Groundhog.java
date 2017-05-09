package com.yqc.collection.map;
/**
 * Object的散列码是按地址生成的
 * @author yangqc
 * 2016.6.14
 */
public class Groundhog {
	protected int number;
	public Groundhog(int n){
		number=n;
	}
	public String toString(){
		return "Groundhog #"+number;
	}
}
