package queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {

    }
    public void test1(){}
    public void test2(){}
    public void test3(){}
    public void test4(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        System.out.println("=======================");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

    }
}
