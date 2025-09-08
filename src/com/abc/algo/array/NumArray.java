package com.abc.algo.array;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2025/9/8 21:48
 * @Version 1.0
 */
public class NumArray {

    private int[] preNums;

    public NumArray(int[] nums) {
        preNums = new int[nums.length+1];
        for(int i=1;i< preNums.length;i++){
            preNums[i] = preNums[i-1] + nums[i-1];
        }
        System.out.println(Arrays.toString(preNums));
    }

    public int sumRange(int left, int right) {
        return preNums[right+1] - preNums[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }


}
