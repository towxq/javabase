/**
 * Created by MSI on 2016/7/9.
 */
public class paixudemo {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
//        int[] arr1 = charutest(arr);
//        int[] arr2 = charudemo2(arr);
//            int[] arr3 = charutest2(arr);
//        for (int m : arr3) {
//            System.out.print(m + ":");
//        }
        quickedemo(arr);

    }

    private static int[] charu(int[] arr) {//插入排序
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i - 1] > arr[i]) {
//                int temp = arr[i];
//                int j = i;
//                while (j > 0 && arr[j - 1] > temp) {
//                    arr[j] = arr[j - 1];
//                    j--;
//                }
//                arr[j] = temp;
//            }
//        }
//        return arr;

        for(int i =1;i<arr.length;i++){
            if (arr[i-1]>arr[i]){
                int temp = arr[i];
                int m = i;
                while(m>0&&arr[m-1]>temp){
                    arr[m]=arr[m-1];
                    m--;
                }
                arr[m]=temp;
            }
        }
        return arr;
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

    private static int[] charudemo(int[] arr) {//插入排序
        for (int i =1;i<arr.length;i++){
            if (arr[i-1]>arr[i]){
                int temp = arr[i];
                int m = i;
                while(m>0&&arr[m-1]>temp){
                    arr[m]=arr[m-1];
                    m--;
                }
                arr[m]=temp;
            }
        }
        return arr;
    }






    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }


    public static void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            quickSort(list, low, middle - 1);        //对低字表进行递归排序
            quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    public static void quick(int[] a2) {
        if (a2.length > 0) {    //查看数组是否为空
            quickSort(a2, 0, a2.length - 1);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (int m : a2) {
            System.out.print(m + ":");
        }
    }


    public static void quickdemo(int[] a1) {
        if (a1.length > 0) {    //查看数组是否为空
            quickSortdemo(a1, 0, a1.length - 1);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (int m : a1) {
            System.out.print(m + ":");
        }
    }


    public static void quickSortdemo(int[] list, int left, int right) {
        if (left < right) {
            int middle = getMiddledemo(list, left, right);  //将list数组进行一分为二
            quickSortdemo(list, left, middle - 1);        //对低字表进行递归排序
            quickSortdemo(list, middle + 1, right);       //对高字表进行递归排序
        }
    }

    public static int getMiddledemo(int[] list, int left, int right) {
       int temp = list[left];
        while(left<right){
            while(left<right && list[right]>=temp){
                right--;
            }
            list[left]=list[right];
            while(left<right && list[left]<=temp){
                left++;
            }
            list[right]=list[left];
        }
        list[left] = temp;
        return left;
    }

    public static int[] xuanzetest(int[] a){
        for(int i = 0;i<a.length;i++){
            for(int n = i+1;n<a.length;n++){
                if(a[i]>a[n]){
                    int temp = a[i];
                    a[i] = a[n];
                    a[n] =temp;
                }
            }
        }
        return a;

    }

    public static int[] maopaotest(int[] a){
        for (int i = 0;i<a.length;i++){
            for (int n =0;n<a.length-i-1;n++){
                if (a[n]>a[n+1]){
                    int temp = a[n];
                    a[n] = a[n+1];
                    a[n+1]  =temp;
                }
            }
        }
        return a;
    }


    public static int[] charutest(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i-1]>a[i]) {
                int temp = a[i];
                int m = i;
                while(m>0&&a[m-1]>temp){
                    a[m]=a[m-1];
                    m--;
                }
                a[m] =temp;
            }
            }
        return a;
        }


    public static void quicktest(int[] a){
        if(a.length>0){
            quickSorttest(a, 0, a.length - 1);
        }
        for (int m : a) {
            System.out.print(m + ":");
        }
    }

    private static void quickSorttest(int[] list, int left, int right) {
        if (left<right){
            int middle = getMiddletest(list, left, right);
            quickSorttest(list,left,middle-1);
            quickSorttest(list,middle+1,right);
        }
    }

    private static int getMiddletest(int[] list, int left, int right) {
       int temp = list[left];
        while(left<right){
            while(left<right&&list[right]>=temp){
                right--;
            }
            list[left]=list[right];
            while(left<right&&list[left]<=temp){
                left++;
            }
            list[right]=list[left];
        }
        list[left] = temp;
        return left;
    }


    public static int[] charudemo2(int[] a){
        for (int i=1;i<a.length;i++){
            if(a[i-1]>a[i]){
                int temp = a[i];
                int m = i;
                while(m>0&&a[m-1]>temp){
                    a[m]=a[m-1];
                    m--;
                }
                a[m]=temp;
            }
        }
        return a;
    }

    public static void quickdemo2(int[] a){
        if (a.length>0){
            quicksortdemo2(a,0,a.length-1);
        }
        for (int m : a) {
            System.out.print(m + ":");
        }
    }

    public static void quicksortdemo2(int[] a, int left, int right) {
        if(left<right){
            int middle  = getMiddledemo2(a,left,right);
            quicksortdemo2(a,left, middle-1);
            quicksortdemo2(a,middle+1,right);
        }
    }

    public static int getMiddledemo2(int[] a, int left, int right) {
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
        a[left]= temp;
        return left;
    }

    public static int[] charutest2(int[] a){
        for(int i =1;i<a.length;i++){
            if(a[i-1]>a[i]){
                int temp = a[i];
                int m = i;
                while(m>0&&a[m-1]>temp){
                    a[m]=a[m-1];
                    m--;
                }
                a[m] =temp;
            }
        }
        return a;
    }

    public static void quickedemo(int[] a){
        if (a.length>0){
            quickSorttest2(a,0,a.length-1);
        }
        for (int m : a) {
            System.out.print(m + ":");
        }
    }

    private static void quickSorttest2(int[] a,int left,int right) {
        if (left<right){
            int middle = quickmiddle(a, left, right);
            quickSorttest2(a,left,middle-1);
            quickSorttest2(a,middle+1,right);
        }

    }

    private static int quickmiddle(int[] a, int left, int right) {
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

}

class Singleee{
    private static final Singleee s = new Singleee();
    private Singleee(){}
    public Singleee getInstance(){
        return s;
    }
}

class Singleeee{
    private static Singleeee s = null;
    private Singleeee(){}
    public Singleeee getInstance(){
        if (s==null){
            return new Singleeee();
        }
        return s;
    }
}

class sin{
        private static final sin s= new sin();
        private sin(){}
        public sin getInstance(){
            return s;
        }
        }

class sin1{
    public static sin1 s = null;
    private sin1(){}
    public static sin1 getInstance(){
        if (s==null){
            return new sin1();
        }
        return s;
    }

}