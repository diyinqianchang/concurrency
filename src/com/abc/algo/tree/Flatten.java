package com.abc.algo.tree;

/**
 * @Author Administrator
 * @Date 2025/9/6 16:02
 * @Version 1.0
 */
public class Flatten {


    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null){
            root = root.right;
        }
        root.right = temp;

    }

    public void traverse(TreeNode root) {
        if (root == null){
            return;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Flatten flatten = new Flatten();
        flatten.flatten(root);
        flatten.traverse(root);
    }
}
