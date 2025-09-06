package com.abc.algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2025/9/6 11:16
 * @Version 1.0
 */
public class Learn1 {

    int maxDiameter = 0;

    private List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        res.add(root.val);
        res.addAll(preOrderTraversal(root.left));
        res.addAll(preOrderTraversal(root.right));
        return res;
    }

    private int diameterOfBinaryTree(TreeNode root) {
      maxDepth(root);
      return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter,left + right);
        return Math.max(left,right) + 1;
    }


    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("从节点 %s 进入节点 %s \n",root,root.left);
        traverse(root.left);
        System.out.printf("从节点 %s 回到点 %s \n",root.left,root);

        System.out.printf("从节点 %s 进入节点 %s \n",root,root.right);
        traverse(root.right);
        System.out.printf("从节点 %s 回到点 %s \n",root.right,root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Learn1 learn1 = new Learn1();
//        System.out.println(learn1.preOrderTraversal(root));
//        System.out.println(learn1.diameterOfBinaryTree(root));
        learn1.traverse(root);

    }


}
