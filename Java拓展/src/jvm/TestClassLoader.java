package jvm;

/**
 * 类加载器（ClassLoader）顺序：
 * 1.应用程序类加载器
 *
 * 2.ext扩展类加载器
 *
 * 3.启动类加载器
 *
 * 4.自定义加载器
 *
 * 双亲委派
 *
 */
public class TestClassLoader {
    public static void main(String[] args) {
        System.out.println(Test.class.getClassLoader().getParent().toString());
    }
}
