package thinkinjava.test16;

import java.util.Arrays;

public class ReturnTest {
	public static Integer[] f(int i){
		Integer[] a=new Integer[i];
		for(int j=0;j<i;j++){
			a[j]=j;
		}
		return a;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(ReturnTest.f(3)));
	}
}
