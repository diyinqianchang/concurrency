package com.abc.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Administrator
 * @Date 2025/9/6 17:28
 * @Version 1.0
 */
public class PrintTree {

    public static void traversePre(TreeNode root) {
        if (root == null){
            return;
        }
        System.out.println(root.val);
        traversePre(root.left);
        traversePre(root.right);
    }

    public static void traverseIn(TreeNode root) {
        if (root == null){
            return;
        }
        traverseIn(root.left);
        System.out.println(root.val);
        traverseIn(root.right);
    }

    public static void traversePost(TreeNode root) {
        if (root == null){
            return;
        }
        traversePost(root.left);
        traversePost(root.right);
        System.out.println(root.val);
    }

    public static void levelOrder(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
    }


}

