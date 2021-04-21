package lock.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C {
    public static void main(String[] args) {
        new Thread(()->{},"A").start();
        new Thread(()->{},"B").start();
        new Thread(()->{},"C").start();
    }
}
class Data3{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int number = 1;


    private void printA(){
        lock.lock();
        try {
            while (number!=1){
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>AAAAA");
            number=2;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    private void printB(){

    }
    private void printC(){

    }
    private void printD(){

    }
}
