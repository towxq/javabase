package 数据结构和算法.leetcode简单题目;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static void main(String[] args){
        int[] nums  = new int[]{2,7,11,15};
        int target = 13;
        int[] a = twosum3(nums,target);
        for (int m = 0;m<a.length;m++){
            System.out.println(a[m]);
        }
    }


    //暴力法遍历每个元素
    private static int[] twosum1(int[] nums, int target) {
        for (int i = 0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    //两遍遍历哈希表
    private static int[] twosum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i = 0;i<nums.length;i++){
            int num  = target-nums[i];
            if (map.containsKey(num) && map.get(num)!=i){
                return  new int[]{i,map.get(num)};
            }
        }

        return null;
    }

    //一遍哈希表
    public static int[] twosum3(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0;i<nums.length;i++){
            int num = target-nums[i];
            if (map.containsKey(num)){
                return new int[]{map.get(num),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
//给定一个整数数组nums和一个目标值target，在该数组中找出和为目标值的两个整数，并返回他们的下标，你可以假设每种输入只会对应一个答案，但是，你不能重复利用这个数组中同样的元素