package com.abc.algo.dynamic;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2026/5/10 14:39
 * @Version 1.0
 */
public class FibTest {


    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibMem(int n, int[] mem) {
        if (n <= 1) {
            return n;
        }
        if (mem[n] != -1) {
            return mem[n];
        }
        mem[n] = fibMem(n - 1, mem) + fibMem(n - 2, mem);
        return mem[n];
    }

    static int fibDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[n][m];

    }


    static int coinChange2DP(int[] coins, int amt){
        // dp[i][a] 前i种硬币能够凑出金额a的最少个数
        int n = coins.length;
        int MAX = amt + 1;
        int[][] dp = new int[n + 1][amt + 1];
        for (int i = 1; i <= amt; i++) {
            dp[0][i] = MAX;
        }
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= amt; a++) {
                // 如果可选的硬币面额大于当前金额a，则无法凑出金额a
                if (coins[i - 1] > a){
                    dp[i][a] = dp[i - 1][a];
                }else{
                    // 否则，可以选择当前硬币或者不选择当前硬币。取选择或不选择中较小的结果
                    // 如果选择硬币 则在前i种硬币中凑出金额a-coins[i-1] + 选择当前硬币的1
                    dp[i][a] = Math.min(dp[i - 1][a], dp[i][a - coins[i - 1]] + 1);
                }

            }
        }
        return dp[n][amt] != MAX ? dp[n][amt] : -1;
    }

    static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    static int dp(int[][] matrix, int i, int j){
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length){
            return 99999;
        }
        if (i == 0){
            return matrix[i][j];
        }
        return Math.min(dp(matrix,i - 1,j - 1), Math.min(dp(matrix,i - 1,j), dp(matrix,i - 1,j + 1))) + matrix[i][j];
    }


    static int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    int minPrev = dp[i - 1][j];
                    if (j > 0) {
                        minPrev = Math.min(minPrev, dp[i - 1][j - 1]);
                    }
                    if (j < m - 1) {
                        minPrev = Math.min(minPrev, dp[i - 1][j + 1]);
                    }
                    dp[i][j] = minPrev + matrix[i][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
    }

    static int maxSubArraySum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }



    public static void main(String[] args) {
//        System.out.println(minFallingPathSum2(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
        System.out.println(maxSubArraySum(new int[]{-3,1,3,-1,2,-4,2}));
    }


}
