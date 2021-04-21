package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Volatile是Java虚拟机提供的轻量级同步机制
 * 1.保证可见性
 * 2.不保证原子性
 * 3.禁止指令重排
 *
 * 什么是JMM?
 * Java内存模型 概念，约定！
 * 关于JMM的一些同步的约定：
 * 1.线程解锁前，必须把共享变量立刻刷回主存
 * 2.线程加锁前，必须把主存中的最新值放到工作内存中
 * 3.加锁和解锁是同一把锁
 */
public class volatiledemo {
    //volatile不保证原子性
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add(){
        num.getAndIncrement(); //+1方法
    }

    public static void main(String[] args) {
        //理论上应该是20000
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){ // Java里默认执行的两个线程 main gc
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+""+num);
    }
}
