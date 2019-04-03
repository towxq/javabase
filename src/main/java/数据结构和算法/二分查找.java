package 数据结构和算法;

public class 二分查找 {
    public static void main(String[] args){
        int[] numtext = {1,3,4,9,12,14,18,21,24,31,34,44,58,61,74,89,91};
        int m = binarySearch(numtext,24);
        System.out.println(m);

    }

    public static int binarySearch(int[] nums, int target){
        if (nums == null || nums.length ==0){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}

//初始条件：left=0,right=length-1
//终止：left>right
//向左查找 right = mid -1
//向右查找 left = mid+1

