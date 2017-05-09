package thinkinjava.test9;
/*
 * 初步正则表达式
 */
import java.util.Arrays;

public class Splitting {
	public static String knights="Then, when you have found the" +
			" shrubbery, you must "+"cut down the mightiest tree in the" +
					"forest... "+"with... a herring!";
	public static String s1="Java now has regular expressions";
	public static void split(String expression,String regex){
		System.out.println(Arrays.toString(expression.split(regex)));
	}
	public static void main(String[] args) {
		split(knights," ");//以空格来划分字符
		split(knights,"\\W+");//以非单词字符划分，将标点删除了
		split(knights,"n\\W+");//字母n后面跟着一个或多个非单词字符
		split(s1,"^Java");
		split(s1,"s?");
		split(s1,"s+");
		split(s1,"s*\"d");
	}
}