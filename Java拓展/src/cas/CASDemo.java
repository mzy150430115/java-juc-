package cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo {
    public static void main(String[] args) {

        //CAS CompareAndSet 比较当前工作内存的值和主内存的值，
        // 如果这个值是期望的 则执行 如果不是 就一直循环（因为底层是自旋锁）
        // 缺点：循环会浪费时间 一次性只能保证一个共享变量的原子性 存在ABA问题
        // Tip：ABA问题：你所期望的值出现 并不是之前的那个值 可能被人做过手脚了
        //AtomicInteger atomicInteger = new AtomicInteger(2000);
        //public final boolean compareAndSet(int expect, int update)
        //Tip：如果泛型是一个包装类 注意对象引用问题
        // 一般在业务中 引用的都是对象
        AtomicStampedReference<Integer> atomicInteger = new AtomicStampedReference<>(2020, 1);

        new Thread(()->{
            int stamp = atomicInteger.getStamp(); //获得版本号
            System.out.println("a1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();
        new Thread(()->{
            int stamp = atomicInteger.getStamp(); //获得版本号
            System.out.println("b1=>"+stamp);
        },"b").start();
        //如果我期望的值达到了，那么就更新 否则不更新
        //------------------捣乱的线程（做过手脚了）---------------------------
//        System.out.println(atomicInteger.compareAndSet(2020, 2021));
//        System.out.println(atomicInteger.get());
//        System.out.println(atomicInteger.compareAndSet(2021, 2020));
//        System.out.println(atomicInteger.get());
//        //-----------------期望的线程------------------------------------------
//        System.out.println(atomicInteger.compareAndSet(2020,6666));
//        System.out.println(atomicInteger.get());

    }
}
