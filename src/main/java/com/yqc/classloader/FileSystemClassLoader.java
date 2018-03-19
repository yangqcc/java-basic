package com.yqc.classloader;

import java.io.*;

/**
 * 自定义类加载步骤,符合双亲委派机制
 * <p>
 * (1)首先检查请求的类型是否已经被这个类装载器装载到命名空间中了如果已经装载，直接返回；
 * (2)如果没有装载，委派类加载请求给父类加载器，如果父类加载器能够完成，则返回父类加载器的Class实例。
 * (3)如果父类没有装载，再调用本类加载器的findClass（…）方法，试图获取对应的字节码，如果获取得到，则调用defineClass（…）导入类型到方法区；
 * (4)如果获取不到对应的字节码或者其他原因失败，返回异常给loadclass（…）,loadclass（…）转抛异常，终止加载过程。
 * 2018/3/19
 */
public class FileSystemClassLoader extends ClassLoader {
    //com.lgd.User    -->  d:/myjava/    com/lgd/User.class
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    //重写方法
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);//查找已加载的类
        //应该要先查询有没有加载过这个类。如果已经加载，不为空，则直接返回加载好的类。
        //如果没有，则加载新的类。
        if (c != null) {
            return c;
        } else {
            //获得他的父类，让父类去加载去加载
            ClassLoader parent = this.getParent();  //获得appclassloader
            //采用的是双亲委派机制
            try {
                c = parent.loadClass(name);//委派给父类加载
            } catch (Exception e) {
                e.printStackTrace();
            }
            //如果不为空，返回父类加载。
            if (c != null) {
                return c;
            } else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    //defineClass方法可以将字节数组转换为Class对象
                    c = defineClass(name, classData, 0, classData.length);
                }
            }
        }
        return c;
    }

    /**
     * 自定义类加载
     *
     * @param classname
     * @return
     */
    private byte[] getClassData(String classname) {
        String path = rootDir + "/" + classname.replace('.', '/') + ".class";
        //IOUtils,可以使用它将流中的数据装换成字节数组
        InputStream is = null;
        //字节输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp = is.read(buffer)) != -1) {
                baos.write(buffer, 0, temp);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
