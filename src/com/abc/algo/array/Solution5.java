package com.abc.algo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2026/4/22 14:34
 * @Version 1.0
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度
 *
 * 输入：nums = [0,1]
 * 输出：2
 * 说明：[0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 */
public class Solution5 {


    public int findMaxLength(int[] nums) {
        int res = 0;
        // 将0视为-1，问题转化为寻找和为0的最长子数组
        // 使用前缀和 + HashMap
        // key: 前缀和, value: 该前缀和第一次出现的索引
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1); // 初始化，前缀和为0时索引为-1
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 遇到1加1，遇到0减1
            prefixSum += (nums[i] == 1 ? 1 : -1);
            if (prefixSumMap.containsKey(prefixSum)) {
                // 如果当前前缀和之前出现过，说明这两个索引之间的子数组和为0
                // 即0和1的数量相同
                int length = i - prefixSumMap.get(prefixSum);
                res = Math.max(res, length);
            } else {
                // 记录该前缀和第一次出现的索引
                prefixSumMap.put(prefixSum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] nums = {0,1,1,1,1,1,0,0,0};
        // [0,1,2,3,4,5,5,5,5]
        // [-1,0,1,2,3,4,3,2,1]
        System.out.println(solution5.findMaxLength(nums));
    }



}
