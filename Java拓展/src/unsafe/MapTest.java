package unsafe;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentModificationException
 */
public class MapTest {
    public static void main(String[] args) {
        //map 是这样用的 不是 工作中 不用hashmap ConcurrentHashMap
        // 默认等价于什么？
        HashMap<String,Object> map = new HashMap<String,Object>(16,0.75f);
        // 加载因子 初始化容量
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }
}
