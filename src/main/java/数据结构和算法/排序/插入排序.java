package 数据结构和算法.排序;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {2,12,35,1,45,6,7,79,14,65,22};
        arr = charu(arr);
        for (int m:arr){
            System.out.print(m+"-");
        }
    }

    private static int[] charu(int[] arr) {
       for (int i =0;i<arr.length;i++){
               int m = arr[i];
               int index = i-1;
               while(index>=0&&arr[index]>m){
                   arr[index+1] = arr[index];
                   index--;
               }
               arr[index+1] = m;
       }
        return arr;
    }
}
