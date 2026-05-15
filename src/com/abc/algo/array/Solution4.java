package com.abc.algo.array;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2026/4/21 20:35
 * @Version 1.0
 */
public class Solution4 {


    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
            System.out.println(Arrays.toString(dp));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
//        int[] nums = {8,3,4,2,7,4};
//        System.out.println(solution4.lengthOfLIS(nums));
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(solution4.maxEnvelopes(envelopes));
    }

}
