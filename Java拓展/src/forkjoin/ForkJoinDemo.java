package forkjoin;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinDemo 工作窃取 当一条线程还没有执行完毕前 可以把他的资源提前分配给其他线程
 * 如何使用forkjoin？
 * 1.forkjoinPool 通过他执行
 * 2.计算任务 forkJoinPool.execute(ForkJoinTask task)
 * 3.计算类要继承 ForkJoinTask
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    //临界值
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public Long test() {
        //求和计算的任务
        if((end-start)<temp){
            Long sum = 0L;
            for (Long i = start; i < end; i++) {
                sum+=i;
            }
            return sum;
        }else { //forkJoin
            //分支合并计算
            Long middle = (start+end) /2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();   //拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task2.fork();   //拆分任务，把任务压入线程队列
            return task1.join() + task2.join();
        }
    }

    //计算的返回值
    @Override
    protected Long compute() {
        return null;
    }
}
