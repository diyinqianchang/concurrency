package algo.tree;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2024/4/27 22:39
 * @Version 1.0
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            List<TreeNode> pollList = queue.poll();
            List<TreeNode> offerList = new ArrayList<>();
            for (TreeNode node : pollList) {
                temp.add(node.val);
                if (node.left != null){
                    offerList.add(node.left);
                }
                if (node.right != null){
                    offerList.add(node.right);
                }
            }
            if (!offerList.isEmpty()){
                queue.offer(offerList);
            }
            result.add(temp);

        }
        return result;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));
        while (!queue.isEmpty()){
            List<TreeNode> pollList = queue.poll();
            double sum = 0.0;
            int size = pollList.size();
            List<TreeNode> offerList = new ArrayList<>();
            for (TreeNode node : pollList) {
                sum = sum+node.val;
                if (node.left != null){
                    offerList.add(node.left);
                }
                if (node.right != null){
                    offerList.add(node.right);
                }
            }
            if (!offerList.isEmpty()){
                queue.offer(offerList);
            }
            double arr = sum / (double)size;
            result.add(Double.valueOf(arr));

        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<TreeNode> pollList = new ArrayList<>();
        pollList.add(root);
        bfs(pollList,result);
        return result;
    }

    private void bfs(List<TreeNode> pollList, List<List<Integer>> result){
        List<Integer> temp = new ArrayList<>();
        List<TreeNode> offerList = new ArrayList<>();
        for (TreeNode node : pollList) {
            temp.add(node.val);
            if (node.left != null){
                offerList.add(node.left);
            }
            if (node.right != null){
                offerList.add(node.right);
            }
        }
        if (!offerList.isEmpty()){
            bfs(offerList,result);
        }
        result.add(temp);
    }

    public boolean isSymmetric2(TreeNode root) {

        if (root == null){
            return false;
        }
        return isSymmetric3(root.left,root.right);
    }

    private boolean isSymmetric3(TreeNode left,TreeNode right) {
        if (left!=null && right!=null){
            if (left.val == right.val){
                return isSymmetric3(left.left,right.right) && isSymmetric3(left.right,right.left);
            }
        }
        if (left == null && right == null){
            return true;
        }
        return false;
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int depth = 0;
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));
        while (!queue.isEmpty()){
            List<TreeNode> pollList = queue.poll();
            List<TreeNode> offerList = new ArrayList<>();
            for (TreeNode node : pollList) {
                if (node.left != null){
                    offerList.add(node.left);
                }
                if (node.right != null){
                    offerList.add(node.right);
                }
            }
            if (!offerList.isEmpty()){
                queue.offer(offerList);
            }
            depth++;
        }
        return depth;
    }


    public int countNodes(TreeNode root) {

        if (root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        paths.add(root.val);
        traversal(root,paths,res);
        return res;
    }
    // 子节点
    void traversal(TreeNode root,List<Integer> paths,List<String> temp){

        if (root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for (Integer integer : paths) {
                sb.append(integer).append("->");
            }
            sb.delete(sb.length()-2,sb.length());
            temp.add(sb.toString());
            return;
        }
        if (root.left != null){
            paths.add(root.left.val);
            traversal(root.left,paths,temp);
            paths.remove(paths.size()-1);
        }
        if (root.right != null){
            paths.add(root.right.val);
            traversal(root.right,paths,temp);
            paths.remove(paths.size()-1);
        }
    }



    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        int i1 = nums.length / 2;
        TreeNode root = new TreeNode(nums[i1]);
        root.left = sortedArrayToBST2(Arrays.copyOfRange(nums,0,i1));
        root.right = sortedArrayToBST2(Arrays.copyOfRange(nums,i1+1,nums.length));
        return root;
    }

    int depth = 0;
    int res = 0;
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        traverse2(root.left);
        int i = res;
        res = 0;
        depth = 0;
        traverse2(root.right);
        int i1= res;
        res = 0;
        depth = 0;
        if (Math.abs(i-i1) <= 1){
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    void traverse2(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        depth++;
        if (treeNode.left == null && treeNode.right == null){
            res = Math.max(res,depth);
        }
        traverse2(treeNode.left);
        traverse2(treeNode.right);
        depth--;
    }




    public int minDepth(TreeNode root,int d) {
        if (root == null){
            return 0;
        }
        d++;
        int t1 = Integer.MAX_VALUE;
        int t2 = Integer.MAX_VALUE;
        if (root.left != null){
            t1 = minDepth(root.left,d);
        }
        if (root.right != null){
            t2 = minDepth(root.right,d);
        }
        if (root.left == null && root.right == null){
            return d;
        }
        return (t1<t2)?t1:t2;

    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || targetSum == 0){
            return false;
        }
        return traversa(root,targetSum-root.val);
    }

    private boolean traversa(TreeNode root,int targetSum){
        if (root.left == null && root.right == null){
            if (targetSum == 0){
                return true;
            }
            return false;
        }
        if (root.left != null){
            targetSum  = targetSum - root.left.val;
            boolean traversa = traversa(root.left, targetSum);
            if (traversa){
                return true;
            }
            targetSum  = targetSum + root.left.val;
        }
        if (root.right != null){
            targetSum  = targetSum - root.right.val;
            boolean traversa = traversa(root.right, targetSum);
            if (traversa){
                return true;
            }
            targetSum  = targetSum + root.right.val;
        }
        return false;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        int balanced = solution.minDepth(root,0);
        System.out.println(balanced);

    }
}
