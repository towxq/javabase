package 数据结构和算法.排序;

/**
 * @author wxq
 * @ClassName Test
 * @Description TODO
 * @date 2021/4/27  17:00
 */
public class Test {
    public static void main(String[] args) {
//        int [] arr = generateRandomArray(10,10);
//        for (int i:arr){
//            System.out.print(i+",");
//        }

//        int a = 6;
//        int b = 10;
//
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println(a);
//        System.out.println(b);

        int[] arr = {6, 10};
        arr[0] = arr[0] ^ arr[1];
        System.out.println(arr[0]);//12
        System.out.println(arr[1]);//10
        arr[1] = arr[0] ^ arr[1];
        System.out.println(arr[0]);//12
        System.out.println(arr[1]);//6
        arr[0] = arr[0] ^ arr[1];
        System.out.println(arr[0]);//10
        System.out.println(arr[1]);//6
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //Math.random() [0,1)
        //Math.random() * N [0,N)
        //(int)(Math.random() * N) [0,N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
//            [-?]--[+?]
            arr[i] = (int) ((maxValue + 1) * Math.random() - (int) (maxValue * Math.random()));
        }
        return arr;
    }
}