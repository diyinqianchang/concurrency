package com.abc.algo.tree;

/**
 * @Author Administrator
 * @Date 2025/9/6 12:12
 * @Version 1.0
 */
public class MaxPathSum {


    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }

    private int maxPathSumHelper(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(0, maxPathSumHelper(root.left, maxSum));
        int rightMax = Math.max(0, maxPathSumHelper(root.right, maxSum));
        int subNodeSum = root.val + leftMax + rightMax;
        maxSum[0] = Math.max(maxSum[0], subNodeSum);
        System.out.println(root.val + " " + leftMax + " " + rightMax + " " + maxSum[0] + " "+subNodeSum);
        return root.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(root));
    }

}
