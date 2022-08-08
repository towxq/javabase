package 基础知识;

import java.util.Objects;

/**
 * @author wxq
 * @ClassName trydemo
 * @Description TODO
 * @date 2021/6/13  23:26
 */
public class trydemo {
    public static void main(String[] args) {
        int az = trycatchdemo();
        String a = new String("ab");
        String b = new String("ab");
        String aa = "ab";
        String bb = "ab";
        boolean equals = Objects.equals(aa,bb);
        System.out.println(equals);
        System.out.println(az);
    }
//jvm处理了return问题
    private static int trycatchdemo() {
        try {
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }
}
