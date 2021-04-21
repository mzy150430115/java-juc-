package pool;

import java.util.concurrent.*;

/**
 * Executors 线程池 三大问题！
 * 1.三大方法：newFixedThreadPool() newSingleThreadExecutor() newCachedThreadPool();
 * 2.自定义线程池七个参数：
 * 3.四种拒绝策略：AbortPolicy //会抛出异常
 *              CallerRunsPolicy //哪来的去哪里，main
 *              DiscardOldestPolicy //队列满了 会尝试与第一个竞争 也不会抛出异常 比下面这个尝试了一下
 *              DiscardPolicy //队列满了 丢掉任务 不会抛出异常
 */

public class Demo01 {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(5); //固定的
        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单例的
        Executors.newCachedThreadPool(); //可伸缩的
        //第二个参数，最大线程该如何定义
        // 获取CPU核数
        //1.CPU密集型 几核 就是几 可以保持  CPU最效率
        //2.IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
        new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(),//工作中应该按照具体服务器上的CPU来定义
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 10; i++) {
            new Thread().start(); //传统的方式
        }


        try {
            for (int i = 0; i < 10; i++) {
                //使用线程池创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //程序结束用完，关闭线程池。
            threadPool.shutdown();
        }


    }
}
