package com.abc.algo.tree;

import java.util.HashMap;

/**
 * @Author Administrator
 * @Date 2025/9/6 17:17
 * @Version 1.0
 */
public class BuildTree {


    private TreeNode constructMaximumBinaryTree(int[] nums){
        return build(nums,0,nums.length-1);
    }
    private TreeNode build(int[] nums, int low, int high){
        if (low > high){
            return null;
        }
        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for (int i = low; i <= high; i++) {
            if (nums[i] > maxVal){
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums,low,index-1);
        root.right = build(nums,index+1,high);
        return root;
    }



    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,
                              int[] inorder,int inStart,int inEnd){
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1){
            return null;
        }
        int leftSubtreeSize = rootIndex - inStart;
        root.left = buildTree(preorder,preStart+1,preStart + leftSubtreeSize,
                inorder,inStart,rootIndex-1);

        root.right = buildTree(preorder,preStart+leftSubtreeSize+1,preEnd,
                inorder,rootIndex+1,inEnd);
        return root;
    }


    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree2(int[] postorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return buildTree2(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree2(int[] postorder,int postStart,int postEnd,
                              int[] inorder,int inStart,int inEnd){
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.getOrDefault(rootVal,-1);
        if (rootIndex == -1){
            return null;
        }
        int leftSize = rootIndex - inStart;

        root.left = buildTree2(postorder,postStart,  postStart+leftSize-1,
                inorder,inStart,rootIndex-1);

        root.right = buildTree2(postorder,postStart + leftSize,postEnd-1,
                inorder,rootIndex+1,inEnd);
        return root;
    }




    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
//        int[] preorder = {3,2,1,6,0,5};
//        TreeNode treeNode = buildTree.constructMaximumBinaryTree(preorder);
//        PrintTree.levelOrder(treeNode);
//
        int[] postorder = {5,6,7,4,2,8,9,3,1};
        int[] inorder =   {5,2,6,4,7,1,8,3,9};
        TreeNode treeNode = buildTree.buildTree2(postorder, inorder);
        System.out.println("");
        PrintTree.traverseIn(treeNode);
    }

}
