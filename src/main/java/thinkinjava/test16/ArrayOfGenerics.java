package thinkinjava.test16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 泛型数组，一般不用，最好还是用泛型容器吧
 * 2015.9.1
 */
public class ArrayOfGenerics {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<String>[] ls;
		List[] la=new List[10];
		ls=la;
		ls[0]=new ArrayList<String>();
		Object[] objects=ls;
		objects[1]=new ArrayList<Integer>();
		List<BerylliumSphere>[] spheres=new List[10];
		for(int i=0;i<spheres.length;i++){
			spheres[i]=new ArrayList<BerylliumSphere>();
		}
		System.out.println(Arrays.toString(spheres));
	}
}
