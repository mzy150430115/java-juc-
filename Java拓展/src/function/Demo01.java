package function;

import java.util.function.Function;

/**
 * Function 函数式接口 有一个输入参数 有一个输出 Function<t,v>
 *     只要是函数型接口，就可以用lambda表达式简化
 */
public class Demo01 {
    public static void main(String[] args) {
        Function function = new Function<String,String>() {
            @Override
            public String apply(String o) {
                return o;
            }
        };

        System.out.println("asd");
    }
}
