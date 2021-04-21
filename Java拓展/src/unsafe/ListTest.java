package unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  java.util.ConcurrentModificationException 并发修改异常
 *
 */
public class ListTest {
    public static void main(String[] args) {
        //并发下Arraylist是不安全的
        //解决方案：1.Vector<String> list = new Vector<>(); vector用synchronized
        //          2.List<String> list = Collections.synchronizedList(new ArrayList<>());
        //          3. List<String> safeList3 = new CopyOnWriteArrayList<>();
        //CopyOnWrite 写入时复制 COW 计算机程序设计领域的优化策略
        //多个线程调用的时候，list，读取的时候，是固定的，写入的时候，可能会存在覆盖操作。
        //在写入的时候 避免覆盖 造成数据问题
        //CopyOnWriteArrayList比Vector好在哪？
        //效率更高
        //读写分离 MyCat ShardingJDBC
        List<String> safeList2 = Collections.synchronizedList(new ArrayList<>());
        Vector<String> safeList = new Vector<>();
        List<String> safeList3 = new CopyOnWriteArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                safeList3.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(safeList3);
            },String.valueOf(i)).start();
        }
    }
}
