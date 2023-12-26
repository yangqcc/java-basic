package basic.collection.map;

import java.util.Map;

public class Maps {
	public static void printKeys(Map<Integer,String> map){
		System.out.println("Size="+map.size()+", ");
	}
	public static void test(Map<Integer,String> map){
		System.out.println(map.getClass().getSimpleName());
//		map.putAll(new Cou);
		printKeys(map);
		System.out.println("Values:");
		System.out.println(map.values());
	}
}
