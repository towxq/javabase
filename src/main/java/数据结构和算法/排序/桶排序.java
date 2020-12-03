package 数据结构和算法.排序;

public class 桶排序 {
    public static void main(String[] args) {
        int[] arr = {2,12,35,1,45,6,7,79,14,65,22};
        arr = bucketSort(arr,79);
        for (int m:arr){
            if (m>0){
                System.out.print(m+"-");
            }
        }
    }

    private static int[] bucketSort(int[] arr, int max) {
        int[] sorted = new int[max+1];
        for (int i = 0;i<arr.length;i++){
            sorted[arr[i]] = arr[i];
        }
        return sorted;
    }
}
