package function;

import java.util.function.Supplier;

/**
 * 供给型接口 Supplier 只有参数，没有返回值
 */
public class Demo04 {
    public static void main(String[] args) {
        Supplier supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println("get()");
                return 1024;
            }
        };
    }
}
