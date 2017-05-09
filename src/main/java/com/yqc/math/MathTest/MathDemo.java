package com.yqc.math.MathTest;
/*
 * 成员变量
 * public static final double PI
 * public static final double E
 * 
 * 成员方法
 * public static int abs(int a);绝对值
 * public static double ceil(double a)向上取整
 * public static double floor(double a)向下取证
 * public static max(int a,int b)
 * 
 * public static double pow(double a,double b) a的b次幂
 * 
 * public static double random() 随机数
 * public static int round(float a) 四舍五入
 * 
 * public souble sqrt(double a)a的正平方根
 */
public class MathDemo {
	public static void main(String[] args) {
		System.out.println("PI:"+Math.PI);
		System.out.println("E:"+Math.E);
		
		System.out.println("Random:"+Math.random());
		//获取一个一到一百之间的随机数
		System.out.println("random:"+((int)Math.random()*100+1));
	}
}
