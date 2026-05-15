package com.abc.algo.dynamic;

import com.abc.algo.tree.MaxPathSum;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2026/5/9 11:49
 * @Version 1.0
 */
public class Knapsack {

    static int knapsack(int[] weights, int[] values, int i, int c) {
        if (i == 0 || c == 0) {
            return 0;
        }
        if (weights[i - 1] > c) {
            return knapsack(weights, values, i - 1, c);
        }
        int no = knapsack(weights, values, i - 1, c);
        int yes = knapsack(weights, values, i - 1, c - weights[i - 1]) + values[i - 1];
        return Math.max(no, yes);
    }

    static int knapsackMem(int[] weights, int[] values, int[][] mem, int i, int c) {
        if (i == 0 || c == 0) {
            return 0;
        }
        if (mem[i][c] != -1) {
            return mem[i][c];
        }
        if (weights[i - 1] > c) {
            return knapsackMem(weights, values, mem, i - 1, c);
        }
        int no = knapsackMem(weights, values, mem, i - 1, c);
        int yes = knapsackMem(weights, values, mem, i - 1, c - weights[i - 1]) + values[i - 1];
        mem[i][c] = Math.max(no, yes);
        return mem[i][c];
    }

    static int knapsack(int[] wgt, int[] val, int cap) {
        int n = wgt.length;
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (wgt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wgt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][cap];
    }

    /**
     * 最少个数 凑零钱
     *
     * @param coins
     * @param amt
     * @return dp[i][a] 前i种硬币能够凑出金额a的最少个数
     */
    static int coinChangeDP(int[] coins, int amt) {
        int n = coins.length;
        int MAX = amt + 1;
        int[][] dp = new int[n + 1][amt + 1];
        for (int a = 1; a <= amt; a++) {
            dp[0][a] = MAX;
        }
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= amt; a++) {
                if (coins[i - 1] > a) {
                    dp[i][a] = dp[i - 1][a];
                } else {
                    dp[i][a] = Math.min(dp[i - 1][a], dp[i][a - coins[i - 1]] + 1);
                }
            }
        }
        return dp[n][amt] != MAX ? dp[n][amt] : -1;
    }


    /**
     * 计算凑零钱的方案总数
     * 使用前i种硬币能够凑出金额a的所有可能组合数
     *
     * @param coins 可用硬币的面额数组
     * @param amt   需要凑出的目标金额
     * @return 能够凑出目标金额的方案总数
     * dp[i][a] = dp[i - 1][a] + dp[i][a - coins[i - 1]];
     * 使用当前状态的组合数量等于不选当前硬币与选当前硬币这两种决策的组合数量之和
     * dp[i][a - coins[i - 1]]
     * 你想⽤⾯值为 2 的硬币凑出⾦额 5， 那么如果你知道了凑出⾦额 3
     * 的⽅法，再加上⼀枚⾯额为 2 的硬币，不就可以凑出 5 了嘛
     */
    static int coinChange2DP(int[] coins, int amt) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amt + 1];

        // 初始化：凑出金额0的方案数为1（什么都不选）
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 动态规划填表：计算前i种硬币凑出金额a的方案数
        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= amt; a++) {
                if (coins[i - 1] > a) {
                    dp[i][a] = dp[i - 1][a];
                } else {
                    dp[i][a] = dp[i - 1][a] + dp[i][a - coins[i - 1]];
                }
            }
        }
        return dp[n][amt];
    }


    static int editDistanceDP(String s1, String s2) {
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

    static int superEggDrop(int k,int n){
       if (k==1){
           return n;
       }
       if (n==0){
           return 0;
       }
       int[][] dp = new int[k+1][n+1];
       for (int i = 1; i <= k; i++) {
           dp[i][1] = 1;
       }
       for (int j = 1; j <= n; j++) {
           dp[1][j] = j;
       }
       for (int i = 2; i <= k; i++) {
           for (int j = 2; j <= n; j++) {
               int min = Integer.MAX_VALUE;
               for (int x = 1; x <= j; x++) {
                   min = Math.min(min, Math.max(dp[i - 1][x - 1], dp[i][j - x]) + 1);
               }
               dp[i][j] = min;
           }
       }
       return dp[k][n];
    }


    static int lengthOfLIS(int[] nums) {
        if (nums == null){
            return 0;
        }
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 遍历4x4矩阵的左下半部分（包括对角线）
     * 左下半部分指行索引 >= 列索引的元素
     */
    static void traverseLowerTriangle() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("遍历4x4矩阵左下半部分元素:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
//        int[] weights = {10, 20, 30, 40, 50};
//        int[] values = {50, 120, 150, 210, 240};
//        int c = 50;
//        System.out.println(knapsack(weights, values, weights.length, c));
//        int i = editDistanceDP("bag", "pack");
//        System.out.println(i);
//        lengthOfLIS(new int[]{1,4,3,4,2,3});
        traverseLowerTriangle();
    }

}
