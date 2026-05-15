package com.abc.algo;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2026/4/22 22:35
 * @Version 1.0
 */
public class ShellSort {

    public static void shellSort(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            System.out.println(gap + "===>" + gap);
            for (int i = gap; i < nums.length; i++) {
                int num = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] > num) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = num;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void shellSort2(int[] nums) {
        int n = nums.length;
        int gap = 1;
        while (gap < n / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int num = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] > num) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = num;
            }
            gap = (gap - 1) / 3;
        }
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8, 4, 3, 6};
        shellSort2(nums);
    }
}
