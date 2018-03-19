package com.yqc.classloader;

public class FileSystemLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loader1 = new FileSystemClassLoader("/home/yangqc/IdeaProjects/java-basic");
        FileSystemClassLoader loader2 = new FileSystemClassLoader("/home/yangqc/IdeaProjects/java-basic");
        Class<?> clazz = loader1.loadClass("com.yqc.annotation.test.AnnotationsDemo1");
        Class<?> clazz2 = loader1.loadClass("com.yqc.annotation.test.AnnotationsDemo1");
        //同一个类加载器及时多次加载,叶子会存在一个类对象
        System.out.println(clazz.hashCode() == clazz2.hashCode());

        Class<?> clazz3 = loader2.loadClass("com.yqc.annotation.test.AnnotationsDemo1");
        System.out.println(clazz3.getClassLoader());


        Class<?> c4 = loader2.loadClass("java.lang.String");
        System.out.println(c4 + "-->" + c4.hashCode());
        //引导类加载器
        System.out.println("-->" + c4.getClassLoader());


        Class<?> c5 = loader2.loadClass("JVMProcess.Demo");
        System.out.println(c5 + "-->" + c5.hashCode());
        //应用类加载器
        System.out.println(c5.getClassLoader());//系统默认的类加载器
    }
}
