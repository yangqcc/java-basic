package com.yqc.classloader.load;

public class LoadClass {

    public static void test() {
        System.out.println(ClassLoader.getSystemClassLoader());//应用类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent());//扩展类加载器
        //引导类加载器  JAVA_HOME/jre/lib/rt.jar
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println(System.getProperty("java.class.path"));
    }

    public static void main(java.lang.String[] args) {
        test();
        System.out.println("#####################");
        String a = new String("LYN");
        //类加载时，采用双亲委派机制，先加载父类，如果没有，再加载子类。
        //实际上加载的是jdk自己提供的包,并没有加载自己定义的java.lang.String
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a);
    }
}
