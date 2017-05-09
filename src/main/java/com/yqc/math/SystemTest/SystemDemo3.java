package com.yqc.math.SystemTest;

import java.util.Arrays;

/*
 * public static void arraycopy(Object src,int srcPos,Object dest,int destPos int length)
 * 注意方法名
 * 从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束
 * 
 * src 源数组，srcPos代表数组中的起始位置
 * dest目标数组
 * destPos目标数组的起始位置
 * length要复制的数组元素的数量
 * 2015.10.2
 */
public class SystemDemo3 {
	public static void main(String[] args) {
		//定义数组
		int [] arr={11,22,33,44,55};
		int [] arr2={6,7,8,9,10};
		System.arraycopy(arr, 1, arr2, 2, 2);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));//注意把源数组复制到目标数组
	}
}
