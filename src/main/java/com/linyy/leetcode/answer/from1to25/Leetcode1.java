package com.linyy.leetcode.answer.from1to25;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class Leetcode1 {

    public static void main(String[] args) {

        int [] nums = new int[]{2,46,46,15};
        int target = 92;
        int [] result = twoSum(nums,target);
        System.out.println(result[0] + "," + result[1]);
    }

    // 用时超过用户数，百分之75
    // 消耗内存超过用户数，百分之88
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>(nums.length,1);
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int sub = 0;
        for(int i=0;i<nums.length;i++){
            sub = target - nums[i];
            if(map.containsKey(sub) && map.get(sub) != i){
                return new int[]{i,map.get(sub)};
            }
        }
        throw new IllegalArgumentException("no result");
    }

    // 79/80 超出时间限制
    public static int[] twoSum1(int[] nums, int target) {

        int sub = 0;
        for(int i=0;i<nums.length;i++){
            sub = target - nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(sub == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("no result");
    }
}
