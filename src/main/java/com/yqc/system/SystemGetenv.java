package com.yqc.system;

/**
 * Created by yangqc on 2017/5/1.
 * <p>
 * getenv获取系统环境变量(window中,获取"环境变量"中"用户变量"和"系统变量"的值)
 */
public class SystemGetenv {

    public static void main(String[] args) {
        System.out.println(System.getenv("path"));
    }
}
