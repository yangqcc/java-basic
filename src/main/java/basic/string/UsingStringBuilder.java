/*
 * StringBuilder���������Ը��ӷ���
 * 2015.2.10
 */
package basic.string;

import java.util.Random;

public class UsingStringBuilder {
	public static Random rand=new Random(47);
	public String toString(){
		StringBuilder result=new StringBuilder("[");
		for(int i=0;i<25;i++){
			result.append(rand.nextInt(100));
			result.append(", ");
		}
		result.delete(result.length()-2, result.length());//�������һ�����źͿո�
		result.append("]");
		return result.toString();//���ض��е�String
	}
	public static void main(String[] args){
		UsingStringBuilder usb=new UsingStringBuilder();
		System.out.println(usb);
	}
}
