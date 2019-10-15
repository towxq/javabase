package 数据结构和算法;

/**
 * Created by MSI on 2016/7/17.
 */
public class quickdemo {
    public static void main(String[] args){
        int[] arr = {51, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 49};
        int[] arr1 = {6,1,2,7,9,3,4,5,10,8};
        int[] arr2 = {5,13,7,8,11,3,27,81,44};
        int[] arr3 = charu(arr);
        for (int m : arr3) {
            System.out.print(m + ":");
        }
//        quick(arr2);
    }

    public static int[] charu(int[] a){
        for (int i = 1;i<a.length;i++){
            if (a[i]<a[i-1]){
                int temp = a[i];
                int m = i;
                while (m>0&&a[m-1]>temp){
                    a[m]=a[m-1];
                    m--;
                }
                a[m]=temp;
            }
        }
        return a;
    }

    private static int[] maopao(int[] arr) {//冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int n = 0; n < arr.length - 1 - i; n++) {
                if (arr[n] > arr[n + 1]) {
                    int swap = arr[n];
                    arr[n] = arr[n + 1];
                    arr[n + 1] = swap;
                }
            }
        }
        return arr;
    }

    private static int[] xuanze(int[] arr) {//选择排序
        for (int i = 0; i < arr.length; i++) {
            for (int n = i + 1; n < arr.length; n++) {
                if (arr[i] > arr[n]) {
                    int swap = arr[i];
                    arr[i] = arr[n];
                    arr[n] = swap;
                }
            }
        }
        return arr;
    }

    public static int[] xuanzetest(int[] arr){
        for (int i = 0;i<arr.length;i++){
            for (int n = i+1;n<arr.length;n++){
                if (arr[i]>arr[n]){
                    int swap = arr[i];
                    arr[i] = arr[n];
                    arr[n] = swap;
                }
            }
        }
        return arr;
    }


    public static int[] maopaotest(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            for (int n = 0;n<arr.length-1-i;n++){
                if (arr[n] > arr[n+1] ){
                    int swap = arr[n];
                    arr[n] = arr[n+1];
                    arr[n+1] = swap;
                }
            }
        }
        return arr;
    }

    public static void quick(int[] a){
        if (a.length>0){
            quicksort(a,0,a.length-1);
        }
//        for (int m : a) {
//            System.out.println(m + ":");
//        }
    }

    private static void quicksort(int[] a,int left,int right) {
        if (left<right){
            int middle = getmiddle(a,left,right);
            for (int m : a) {
                System.out.print(m + ":");
            }
            System.out.println();
            quicksort(a,left,middle-1);
            quicksort(a,middle+1,right);
        }
    }

    private static int getmiddle(int[] a, int left, int right) {
        int temp = a[left];
        while(left<right){
            while(left<right&&a[right]>=temp){
                right--;
            }
            a[left]=a[right];
            while(left<right&&a[left]<=temp){
                left++;
            }
            a[right]=a[left];
        }
        a[left]=temp;
        return left;
    }


    private static int getmiddletest(int[] a, int left, int right) {
        int temp = a[left];
        while(left<right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= a[right]) {
                left++;
            }
            a[right]=a[left];
        }
        a[left] = temp;
        return left;
    }


}