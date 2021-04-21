package jvm;

/**
 * JVM堆内存：
 * 新生代：伊甸园：
 *       幸存区：
 * 老年代：
 * 永久代/元空间（1.8以后就在本地内存里面了，不在堆内存里了）：
 *
 */
public class Test1 {
    public static void main(String[] args) {
        // Xms 初始堆大小
        // Xmx 最大堆大小
        // -XX：NewSize 年轻代大小
        // -XX：NewRatio 年轻代和老年代比值
        // -XX：SurvivorRatio eden区和survivor区比值
        System.out.println("最大内存:" + Runtime.getRuntime().maxMemory() /1024/1024+"M");
    }

}
