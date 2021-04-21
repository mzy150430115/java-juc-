package lockproblem;

import java.util.concurrent.locks.Lock;

/**
 * 可重入锁
 */
public class Demo01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
    }
}

class Phone{
         Lock lock;
    public synchronized void sms(){
        //可重入锁：细节问题：lock unlock必须配对 否则会产生死锁
        lock.lock();
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName()+"sms");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"sms");
    }
}
