package com.yqc.collection.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator iterator 迭代器，集合专用遍历方式
 * <p>
 * E next() 获取元素，返回下一个元素
 * NoSuchElementException;没有这样的元素
 * <p>
 * boolean hasNext() 是否有下一个元素
 * 2015.10.8
 */
public class CollectionIterator {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        c.add("java");
        //Iterator iterator
        Iterator it = c.iterator();//实际返回的是子类对象（多态）
        while (it.hasNext()) {
            System.out.println(it.next());//获取元素并移动到下一个位置
        }

    }
}
