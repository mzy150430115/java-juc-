package future;

import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(
//                ()->{
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName()+"runAsync=Void");
//                }
//        );
//        completableFuture.get(); //获取阻塞执行结果
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync=>Integer");
            return 1024; //供给型函数接口
        });

        //completableFuture.whenComplete(); 完成时返回的结果
        //completableFuture.whenCompleteAsync(); 失败时返回的结果
    }
}
