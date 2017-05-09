package com.yqc.collection.map;

import java.lang.reflect.InvocationTargetException;

public class SpringDetector2 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SpringDetector.detectSpring(Groundhog2.class);
	}
}
