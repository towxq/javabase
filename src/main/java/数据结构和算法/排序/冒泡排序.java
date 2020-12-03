package 数据结构和算法.排序;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {2,12,35,1,45,6,7,79,14,65,22};
        arr = maopao(arr);
        for (int m:arr){
            System.out.print(m+"-");
        }
    }

    private static int[] maopao(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            for (int n = 0;n<arr.length-i-1;n++){
                if (arr[n]<arr[n+1]){
                    int x = arr[n];
                    arr[n] = arr[n+1];
                    arr[n+1] = x;
                }
            }
        }
        return arr;
    }
}
