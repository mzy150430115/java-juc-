package add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //线程数量（停车位）
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <=6; i++) {
            new Thread(()->{
                //acquire 得到
                try {
                    semaphore.acquire();//获得，假设如果满了，等待，直到释放位置
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放，会将当前的信号量释放+1
                }
            },String.valueOf(i)).start();
        }
    }
}
