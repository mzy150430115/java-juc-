package jvm;

import java.lang.ref.SoftReference;

/**
 * 对象的引用类型：
 * 1.强引用：new出来的都是强引用
 * 2.软引用：当内存不足时，垃圾回收会清理此对象
 * 3.弱引用：当垃圾回收触发，就会清理此对象
 * 4.虚引用：
 */
public class YinYong {
    public static void main(String[] args) {
        //强引用
        User user = new User();
        //软引用
        SoftReference<User> soft = new SoftReference<>(new User());


    }
}
