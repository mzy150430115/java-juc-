package hashmap;

import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
    public static void main(String[] args) {
        //HashMap初始化容量，负载因子
        java.util.HashMap hashMap = new java.util.HashMap(30,0.5f);
        /**
         * HashMap扩容机制：
         * 原来的长度和元素组长度进行与运算 如果结果是1，
         * 则在扩容后的位置，如果结果是0，则在原来的位置不变
         * 为什么要用2的n次方-1？
         * 因为2的n次方-1的二进制一定是1111的形式，这种形式与key进行与运算后，性能会更好
         * 如果用其他的，类似于1 2 3 4 5 6这种 那么与出来的结果一定全为0
         * 这样就造成了散链性差，冲突高，HashMap查询性能就不好。
         */
        ConcurrentHashMap map;

    }
}
