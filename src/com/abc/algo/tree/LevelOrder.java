package com.abc.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Administrator
 * @Date 2025/9/7 10:07
 * @Version 1.0
 */
public class LevelOrder {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag){
                    list.add(node.val);
                }else {
                    list.add(0,node.val);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }


    public int maxLevelSum(TreeNode root) {
        int result = 0;
        if (root == null){
            return result;
        }
        int max = Integer.MIN_VALUE;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum = sum+node.val;
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            if (sum > max){
                max = sum;
                result = level;
            }
            level++;
        }
        return result;
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum = sum+node.val;
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return sum;
    }


    public boolean isEvenOddTree(TreeNode root) {
        if (root == null){
            return false;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int pre = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0){
                    if (node.val % 2 == 0 || node.val < pre){
                        return false;
                    }else{
                        pre = node.val;
                    }
                }else {
                    if (node.val % 2 == 1 || node.val > pre){
                        return false;
                    }else{
                        pre = node.val;
                    }
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            level++;
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.isEvenOddTree(root));
    }

}
