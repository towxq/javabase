package 基础知识.函数式接口;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author wxq
 * @ClassName FunctionInterfaceDemo
 * @Description TODO
 * @date 2021/7/12  17:14
 */
public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        Function<String,String> funtion = (str)->{
            return str;
        };
        System.out.println(funtion.apply("wxq"));


        Predicate<String> predicate = (str)->{
            return str.isEmpty();
        };
        System.out.println(predicate.test("wxq"));


        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("wxq");

        Supplier<String> supplier = ()->{
            return "wxq";
        };
        System.out.println(supplier.get());

    }
}
//Function函数式接口  有一个输入参数  有一个输出
//Predicate断定型接口，返回值只能是布尔型
//Consumer消费型接口
//supplier供给型接口