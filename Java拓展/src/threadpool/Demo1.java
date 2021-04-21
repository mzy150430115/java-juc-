package threadpool;

import java.util.concurrent.*;

/**
 * Java线程池
 */
public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //可缓存线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("缓存线程池");
            }
        });
        //定长线程池
        Executors.newFixedThreadPool(10);
        //单线程的线程池
        Executors.newSingleThreadExecutor();
        //计划任务线程池
        ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(10);
        //自定义线程池
        /**
         * corePoolSize,核心线程数
         * maximumPoolSize,最大线程数量
         * keepAliveTime,线程保持等待任务最大空余时间
         * unit,时间单位
         * workQueue,阻塞队列
         * Executors.defaultThreadFactory(),线程工厂
         * defaultHandler 拒绝策略
         */
        ExecutorService myPool = new ThreadPoolExecutor(5,
                10,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(50),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        Runnable myTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("task");
            }
        };

        myPool.execute(myTask);


        Future<String> future = myPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "测试一下";
            }
        });

        //阻塞的方法
        String s = future.get();
        System.out.println("future=>"+s);
    }


}
