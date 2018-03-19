package com.yqc.classloader;

/**
 * java虚拟机类加载器
 *
 * java虚拟机加载字节码后,放入方法区.
 * jdk1.8以前,是永久带,Pergen
 * jdk1.8以后,是元空间Matespacesize
 *
 * 自定义类加载器中,jdk1.8推荐格式
 *
 *   class NetworkClassLoader extends ClassLoader {
 *         String host;
 *         int port;
 *
 *         @Override
 *         public Class findClass(String name) {
 *             byte[] b = loadClassData(name);
 *             return defineClass(name, b, 0, b.length);
 *         }
 *
 *         //该私有方法会根据提供的名字去获取Class文件
 *         //并转换为字节数组
 *         private byte[] loadClassData(String name) {
 *             // load the class data from the connection
 *             &nbsp;.&nbsp;.&nbsp;.
 *         }
 *     }
 */