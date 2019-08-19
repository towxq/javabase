package 数据结构和算法;

public class 数组算法 {
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums){
        if(nums.length<=1){
            return 1;
        }
        int s  = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[s]!=nums[i]){
                s = s+1;
                nums[s] = nums[i];
            }
        }
        return s+1;
    }
}
//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成

//可以维护2个指针，慢指针开始指向数组第一个元素，快指针指向第二个元素，然后快指针不断判断自己当前元素和前一个元素是否相同，
//相同则快指针后移，不相同则将当前值赋值给慢指针的后一个元素，慢指针后移。最后慢指针指向的元素及前面所有元素都是不重复的