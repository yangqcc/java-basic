package com.yqc.math.MathTest;

import java.util.Random;

/*
 * random随机数产生类
 * 构造方法
 * 
 *  public Random() 没有种子（默认种子，当前时间的毫秒值）
 *  public Random(long seed)  给出固定的种子
 *  
 *  给定种子后每次到的的随机数是相同的
 *  没给种子，随机数是不同的
 *  
 *  种子不一样和种子一样有什么区别
 *  
 *  public int nextInt  返回的是int范围内的随机数
 *  public int nextInt(int n) 返回[0,N)范围内的随机数
 */
public class RandomDemo {
	public static void main(String[] args) {
//		Random r=new Random();
		Random r=new Random(111);
		for(int x=0;x<10;x++){
			int num=r.nextInt(100);
			System.out.println(num);
		}
	}
}
