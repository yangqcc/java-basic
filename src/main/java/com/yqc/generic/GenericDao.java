package com.yqc.generic;

import java.util.Set;

/**
 * 
 * 泛型用于数据库的CRUD
 * 2015.10.20
 * @author Yangqc
 *
 */
public class GenericDao<T> {
	public void add(T a){}
	
	public  T finadById(int a){
		return null;
	}
	
	public void delete(T t){
		
	}
	
	public void update(T t){
	}
	
	public Set<T> findByConditions(String s){
		return null;
	}
}
