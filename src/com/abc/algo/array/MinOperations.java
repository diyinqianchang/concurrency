package com.abc.algo.array;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2025/9/9 21:21
 * @Version 1.0
 */
public class MinOperations {

    public int minOperations2(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum < x) {
            return -1;
        }
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        System.out.println("preSum--->"+Arrays.toString(preSum));

        return -1;
    }

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum < x) {
            return -1;
        }
        int right = 0;
        int lsum = 0, rsum = sum;
        int ans = n + 1;
        for (int left = -1; left < n; ++left) {
            if (left != -1) {
                lsum += nums[left];
            }
            while (right < n && lsum + rsum > x) {
                rsum -= nums[right];
                ++right;
            }
            if (lsum + rsum == x) {
                ans = Math.min(ans, (left + 1) + (n - right));
            }
        }
        return ans > n ? -1 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,4,1};
        MinOperations minOperations = new MinOperations();
        System.out.println(minOperations.minOperations2(nums, 5));
    }

}
