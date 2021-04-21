package add;

import java.util.concurrent.CountDownLatch;

/**
 * 减法计数器
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6 倒计时完毕会执行什么操作
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{},String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("close Door");
    }
}
