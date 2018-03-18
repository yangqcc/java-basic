package com.yqc.collection.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 1.void add(int index,Object element)在制定位置添加元素
 * 2.int indexOf(Object o)返回第一次出现的制定元素的索引，如果此列表不包含，则返回-1
 * <p>
 * 列表迭代器
 * 3.ListIterator listIterator() List集合特有的迭代器
 * 4.ListIterator listIterator(int index) 从指定位置开始迭代
 * <p>
 * E previous 返回上一个元素  ***但是这里要注意索引位置，要逆向首先要正向。所以一般使用，没什么意义
 * boolean hasPrevious 可以逆向遍历
 * <p>
 * 5.修改功能
 * Object set(int index,Object element) 根据索引修改元素 返回修改的元素
 * 2015.10.9
 */
public class ListDemo1 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add(1, "android");
        list.add(3, "javaee");
        //该迭代器继承了Iterator迭代器，所以可以直接使用hasNext和next方法
        ListIterator<String> lit = list.listIterator();//返回子类对象
        while (lit.hasNext()) {
            String s = (String) lit.next();
            System.out.println(s);
        }
        System.out.println(lit.previous() + "****");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }
        System.out.println("list:" + list);
    }
}
