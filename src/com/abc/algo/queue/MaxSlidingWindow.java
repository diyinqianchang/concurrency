package com.abc.algo.queue;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2025/9/14 15:39
 * @Version 1.0
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                monotonicQueue.push(nums[i]);
            } else {
                monotonicQueue.push(nums[i]);
                res.add(monotonicQueue.max());
                monotonicQueue.pop(nums[i - k + 1]);
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
    public static int constrainedSubsetSum2(int[] nums, int k){
        int n = nums.length;
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        monotonicQueue.push(nums[0]);
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (i < k - 1) {
                monotonicQueue.push(nums[i]);
            } else {
                monotonicQueue.push(nums[i]);
                int max = monotonicQueue.max();
                int i1 = Math.max(max, 0) + nums[i];
                System.out.println("max:"+ max + " num[i]:" + nums[i] + " = "+(i1));
                maxSum = Math.max(maxSum, i1);
                monotonicQueue.pop(nums[i - k + 1]);
            }
        }
        System.out.println(maxSum);
        return maxSum;
    }

    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        // 使用单调递减双端队列存储 dp 数组的索引
        Deque<Integer> monoQueue = new ArrayDeque<>();
        int maxSum = nums[0];

        for (int i = 0; i < n; i++) {
            // dp[i] 至少包含 nums[i] 本身
            // 如果队列不为空，可以选择前面的最大 dp 值加上当前值
            System.out.println(Arrays.toString(dp));
            int q = monoQueue.isEmpty() ? 0 : Math.max(0, dp[monoQueue.peekFirst()]);
            dp[i] = nums[i] + q;
            // 更新全局最大值
            System.out.println("i "+i+" "+nums[i]+" "+ q);
            maxSum = Math.max(maxSum, dp[i]);
            // 维护单调递减队列的性质
            // 移除所有 dp 值小于等于当前 dp[i] 的元素（因为它们不可能成为后续更大值的候选）
            while (!monoQueue.isEmpty() && dp[monoQueue.peekLast()] <= dp[i]) {
                monoQueue.pollLast();
            }
            // 将当前索引加入队列尾部
            monoQueue.offerLast(i);
            // 移除超出窗口范围的元素（索引距离超过 k）
            if (!monoQueue.isEmpty() && monoQueue.peekFirst() <= i - k) {
                monoQueue.pollFirst();
            }
        }
        System.out.println(Arrays.toString(dp));
        return maxSum;
    }


    public static void main(String[] args) {
        MaxSlidingWindow m = new MaxSlidingWindow();
        int[] nums = {10,2,-10,5,20};
        m.constrainedSubsetSum(nums, 2);
    }


}
