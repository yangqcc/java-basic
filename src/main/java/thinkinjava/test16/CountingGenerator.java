package thinkinjava.test16;

import net.mindview.util.Generator;

public class CountingGenerator {
	public static class Boolean implements Generator<java.lang.Boolean>{
		private boolean value=false;
		public java.lang.Boolean next(){
			value=!value;
			return value;
		}
	}
	public static class Byte implements Generator<java.lang.Byte>{
		private byte value=0;
		public java.lang.Byte next(){
			return value++;
		}
	}
	static char[] chars=("ddsswefewrfewfwefwefweFSAAASCAS").toCharArray();
	public static class Character implements Generator<java.lang.Character>{
		int index=-1;
		public java.lang.Character next(){
			index=(index+1)%chars.length;
			return chars[index];
		}
	}
	public static class String implements Generator<java.lang.String>{
		private int length=7;
		Generator<java.lang.Character> cg=new Character();
		public String(){}
		public String(int length){this.length=length;}
		public java.lang.String next(){
			char[] buf=new char[length];
			for(int i=0;i<length;i++){
				buf[i]=cg.next();
			}
			return new java.lang.String(buf);
		}
	}
}
