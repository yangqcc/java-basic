package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * JDK 1.6下,会出现“PermGen Space”的内存溢出,而在 JDK 1.7和 JDK 1.8 中,会出现堆内存溢出,并且 JDK 1.8中 PermSize 和 MaxPermGen
 * 已经无效.因此,可以大致验证 JDK 1.7 和 1.8 将字符串常量由永久代转移到堆中，并且 JDK 1.8 中已经不存在永久代的结论。
 * JDK1.7以后,便将常量池转到堆里面.
 * 2018/3/18
 */
public class StringOomMock {

    static String base = "string";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }
}
