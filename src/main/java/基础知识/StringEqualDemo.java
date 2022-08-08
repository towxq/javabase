package 基础知识;

/**
 * @author wxq
 * @ClassName StringEqualDemo
 * @Description TODO
 * @date 2021/6/12  21:23
 */
public class StringEqualDemo {
    public static void main(String[] args) {
        String a = new String("ab");//内存地址
        String b = new String("ab");//内存地址
        String aa = "ab";//常量池
        String bb = "ab";//常量池
        if (aa == bb) {
            System.out.println("aa==bb");
        }
        if (a == b) {
            System.out.println("a==b");
        }
        if (a == aa) {
            System.out.println("a==aa");
        }
    }
}
