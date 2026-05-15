package com.abc.algo.backtrack;

import com.abc.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2025/9/27 10:28
 * @Version 1.0
 */
public class PreOrder {

    List<TreeNode> res = new ArrayList<>();

    List<List<TreeNode>> paths = new ArrayList<>();

    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        if (root.val == 7){
            res.add(root);
        }
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrder2(TreeNode root){
        if (root == null || root.val == 3){
            return;
        }
        res.add(root);
        if (root.val == 7){
            paths.add(new ArrayList<>(res));
        }
        preOrder2(root.left);
        preOrder2(root.right);
        res.remove(res.size()-1);
    }



    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        PreOrder preOrder = new PreOrder();
        preOrder.preOrder2(root);
        System.out.println(preOrder.paths);
    }


}
