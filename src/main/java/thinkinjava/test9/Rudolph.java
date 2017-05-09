package thinkinjava.test9;
/*
 * 一些简单的正则表达式
 * 2015.8.17
 */
public class Rudolph {
	public static void main(String[] args) {
		for(String pattern:new String[]{"Rudolph","[rR]udolph",
				"[rR][aeiou][a-z]ol.*","[^y].*"})
		{
			System.out.println("Rudolph".matches(pattern));
		}
	}
}
