package jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义ClassLoader加载当前包下的.class文件
 * 2018/3/18
 *
 * @author yangqc
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(java.lang.String name) throws ClassNotFoundException {
                try {
                    java.lang.String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    //如果不在当前包下面,则使用父类加载
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object object = myLoader.loadClass("jvm.classloader.TestClass").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof jvm.oom.HeapOomMock);
    }
}
