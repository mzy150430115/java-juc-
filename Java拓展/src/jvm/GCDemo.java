package jvm;

/**
 * 垃圾回收算法：
 * Java中自动管理内存（垃圾回收）的方式：
 * 引用计数（Java没有选择，因为循环引用）
 * 可达性分析（跟搜索法 GC Root）
 *
 * 1.标记清除算法（最基础的）：缺点：产生的碎片多，性能比较慢
 *                          优点：算法简单，不需要移动，维护
 * 2.复制算法：缺点：空间用一半，对内存空间的使用做出了高昂的代价。
 * 3.标记整理（压缩）法（解决了上面两种的缺点）：复制最快，占用空间最小
 *
 *
 * 垃圾回收器：
 * 1.Serial Old收集器：一个线程
 * 2.ParNew收集器：多线程（采用复制算法）
 * 3.Parallel Scavenger（新生代）：吞吐量优先（用户执行线程的比例更高一点）
 * 4.CMS（最新JDK版本没有这个了）所有用户线程并发进行
 * 5. G1
 *
 * JVM调优工具：
 * 1.JPS：查看进程，后面还可以加一些参数：-l 看名字 ，-v 看参数，-gc xxx 看内存，
 * 2.Jstat：加载class数量，字节大小，对应时间
 * 3.Jmap：生成当前虚拟机的快照，
 * 4.jhat：查看生成的快照
 * 5.Jinfo：看参数 比jps -v要详细
 *
 *
 *
 * finalization 对象的三种状态：
 *  1.可触达，可触及
 *  2.可复活的
 *  3.
 */
public class GCDemo {
    public static void main(String[] args) {
//        BufferedImage bufferedImage = new BufferedImage();

    }
}
