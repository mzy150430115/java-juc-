package lockproblem;

import lock.pc.A;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinlockDemo {
    //加锁
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    //加锁
    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==>mylock");
        //自旋锁 CAS（只要他不成立 就一直判断）
        while (atomicReference.compareAndSet(null,thread)){

        }
        //解锁
        while (atomicReference.compareAndSet(thread,null)){

        }

    }
}
