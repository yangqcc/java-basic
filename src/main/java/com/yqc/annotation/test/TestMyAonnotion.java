package com.yqc.annotation.test;
/**
 * 自己定义注解
 * 
 * @author Yangqc
 * 2015.10.19
 */
@MyAnnotion(value="abc",arrayAttr={1,1},annotationAttr=@MetaAnnotion("你好"),a=String.class)
public class TestMyAonnotion {

}
