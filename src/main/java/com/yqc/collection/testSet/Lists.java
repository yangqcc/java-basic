package com.yqc.collection.testSet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Lists {
	private static boolean b;
	private static String s;
	private static int i;
	private static Iterator<String> it;
	private static ListIterator<String> lit;
	public static void basicTest(List<String> a){
		a.add(1,"x");
		a.add("x");
		b=a.contains("1");
		s=a.get(1);
		i=a.indexOf("1");
		b=a.isEmpty();
		it=a.iterator();
		lit=a.listIterator();
		lit=a.listIterator(2);
		i=a.lastIndexOf("1");
		a.remove(1);
		a.remove("3");
		a.set(1, "y");
		i=a.size();
		a.clear();
	}
	
	public static void iterMotion(List<String> a){
		ListIterator<String> it=a.listIterator();
		b=it.hasNext();
		b=it.hasPrevious();
		s=it.next();
		i=it.nextIndex();
		s=it.previous();
		i=it.previousIndex();
	}
	
	public static void iterMainpulation(List<String> a){
		ListIterator<String> it=a.listIterator();
		it.add("47");
		it.next();
		it.remove();
		it.next();
		it.set("47");
	}
	
	public static void testVisuabl(List<String> a){
		System.out.println(a);
		a.add("123");
		a.add("1233");
		a.add("fwe");
		a.add("fe");
		System.out.println(a);
		ListIterator<String> x=a.listIterator(a.size());
		x.add("one");
		System.out.println(a);
		System.out.println(x.next());
		x.remove();
		System.out.println(x.next());
		x.set("47");
		System.out.println(a);
		x=a.listIterator(a.size());
		while(x.hasPrevious()){
			System.out.println(x.previous()+" ");
		}
		System.out.println();
		System.out.println("testVisual finished");
	}
	public static void testLinkedList(){
		LinkedList<String> l=new LinkedList<String>();
		l.add("123");
		l.add("freew");
		l.add("cscs");
		l.addFirst("213");
		l.addFirst("fw");
		System.out.println(l);
		System.out.println(l.getFirst());
		System.out.println(l.removeFirst());
		System.out.println(l.removeFirst());
		System.out.println(l.removeLast());
		System.out.println(l);
	}
	
	public static void main(String[] args) {
//		basicTest(new LinkedList<String>())
	}
}
