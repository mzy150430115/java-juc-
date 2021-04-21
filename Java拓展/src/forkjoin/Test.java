package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        // test1(); 累加
        //test2(); //12000 forkjoin
        test3(); //153  stream流
    }
    public static void test1(){}
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L,10_1000_1000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum"+sum+"时间:"+(end-start));
    }
    public static void test3(){
        long start = System.currentTimeMillis();
        //stream并行流计算
        long sum = LongStream.rangeClosed(0L,10_1000_1000).parallel().reduce(0,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum"+sum+"时间:"+(end-start));
    }
}
