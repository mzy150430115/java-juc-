package function;

import java.util.function.Consumer;

/**
 * Consumer 消费型接口 只有输入 没有返回值
 */
public class Demo03 {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>(){
            @Override
            public void accept(String s) {

            }
        };
        consumer.accept("asdasd");

    }
}
