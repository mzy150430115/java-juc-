package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread().start();
        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread); //适配类
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        Object o = futureTask.get(); //获取callable的返回结果 这个get可能会产生阻塞。把他放到最后一行。异步通信来处理。
        System.out.println(o);


    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1024;
    }
}
