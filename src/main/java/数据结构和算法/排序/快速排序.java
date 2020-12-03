package 数据结构和算法.排序;

public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {2,12,35,1,45,6,7,79,14,65,22};
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr,int left,int right) {
        if (left<right){
            int middle = getmiddle(arr,left,right);
            quick(arr,left,middle-1);
            quick(arr,middle+1,right);
        }
        System.out.println();
        for (int a:arr){
            System.out.print(a+"-");
        }
    }

    private static int getmiddle(int[] arr, int left, int right) {
        int temp = arr[left];
        while(left<right){
            while(left<right&&arr[right]>=temp){
                right--;
            }
            arr[left] = arr[right];
            while (left<right&&arr[left]<=temp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}
