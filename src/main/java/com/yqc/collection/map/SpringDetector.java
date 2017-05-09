package com.yqc.collection.map;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * 内容:
 * @author yangqc
 *
 * 2016-6-14
 */
public class SpringDetector {
	public static <T extends Groundhog> void detectSpring(Class<T> type) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Constructor<T> ghog=type.getConstructor(int.class);
		Map<Groundhog,Prediction> map=new HashMap<>();
		for(int i=0;i<10;i++){
			map.put(ghog.newInstance(i), new Prediction());
		}
		System.out.println("map="+map);
		Groundhog gh=ghog.newInstance(3);
		System.out.println("Looking up prediction for "+gh);
		if(map.containsKey(gh)){  //并没有找到Groundhog#3对应的值，因为这里使用的是Object继承而来的散列码
			System.out.println(map.get(gh));  
		}else{
			System.out.println("Key not found:"+gh);
		}
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		detectSpring(Groundhog.class);
	}
}
