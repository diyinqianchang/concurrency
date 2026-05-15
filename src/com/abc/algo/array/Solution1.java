package com.abc.algo.array;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2026/4/21 17:56
 * @Version 1.0
 *
 * 给定⼀个按照升序排列的整数数组 nums，和⼀个⽬标值 target，找出给定⽬标值在数组中的开始位置和结
 * 束位置。如果数组中不存在⽬标值 target，返回 [-1, -1]
 * 输⼊：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class Solution1 {

    public int[] searchRange(int[] nums, int target) {

        return new int[]{leftBound(nums,target),rightBound(nums,target)};
    }

    int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        System.out.println(left);
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {1,3,5,6};
        solution1.leftBound(nums,2);
//        int[] nums = {5,7,7,8,8,10};
//        int[] ints = new Solution1().searchRange(nums, 8);
//        System.out.println(Arrays.toString(ints));
    }


}
