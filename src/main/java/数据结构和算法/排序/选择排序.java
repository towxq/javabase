package 数据结构和算法.排序;

public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {2,12,35,1,45,6,7,79,14,65,22};
        arr = xuzesort(arr);
        for (int m:arr){
            System.out.print(m+"-");
        }
    }

    private static int[] xuzesort(int[] arr) {
        for (int i=0;i<arr.length;i++){
            for (int n = i+1;n<arr.length;n++){
                if (arr[n]<arr[i]){
                    int x = arr[n];
                    arr[n] = arr[i];
                    arr[i] = x;
                }
            }
        }
        return arr;
    }

}
