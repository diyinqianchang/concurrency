package algo.tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Administrator
 * @Date 2024/5/2 11:01
 * @Version 1.0
 */
public class Solution2 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left != null){
            if (root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }
            sumOfLeftLeaves(root.left);
        }
        if (root.right != null){
            sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    public int[] findMode(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        traverse(root,map);
        Map.Entry<Integer, Integer> entry = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed()).findFirst().orElse(null);
        if (entry != null){
            int max = entry.getValue();
            if (map.entrySet().stream().filter(e -> e.getValue() == max).count() > 1){
                return map.entrySet().stream().filter(e -> e.getValue() == max).map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
            }else {
                return new int[]{entry.getKey()};
            }
        }
        return new int[0];
    }
    public void traverse(TreeNode root,Map<Integer,Integer> map){
        if (root == null){
            return;
        }
        traverse(root.left,map);
        if (map.containsKey(root.val)){
            map.put(root.val,map.get(root.val)+1);
        }else {
            map.put(root.val,1);
        }
        traverse(root.right,map);
    }



    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        System.out.println("--->"+list);
        int min = Integer.MAX_VALUE;
        int size = list.size();
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j <size; j++) {
                int abs = Math.abs(list.get(i) - list.get(j));
                System.out.println(list.get(i)+"-"+list.get(j)+"="+abs);
                min = Math.min(min,abs);
            }
        }
        System.out.println("--->"+min);
        return min;
    }
    public void traverse(TreeNode root,List<Integer>list){
        if (root == null){
            return;
        }
        traverse(root.left,list);
        int val = root.val;
        if (list.size() > 0){
            int abs = Math.abs(list.get(list.size()-1) - val);
            min = Math.min(min,abs);
        }
        list.add(root.val);
        traverse(root.right,list);
    }

    int min = Integer.MAX_VALUE;
    public int getMinimumDifference1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        System.out.println(min);
        return min;
    }



//    int sumValue = 0;
    public int findTilt(TreeNode root) {
        int sum = 0;
        if (root == null){
            return sum;
        }
        System.out.println(valueSum(root.left));
        System.out.println(valueSum(root.right));
//        valueSum(root.left);
//        valueSum(root.right);
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            TreeNode poll = queue.poll();
//            int leftValue = valueSum(poll.left);
//            int rightValue = valueSum(poll.right);
//            System.out.println("leftValue:"+leftValue+" rightValue:"+rightValue);
//            sum += Math.abs(leftValue-rightValue);
//            if (poll.left != null){
//                queue.offer(poll.left);
//            }
//            if (poll.right != null){
//                queue.offer(poll.right);
//            }
//        }
//        System.out.println(sum);
        return sum;
    }

    public int valueSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftValue = valueSum(root.left);
        int rightValue = valueSum(root.right);
        return (leftValue+rightValue)+root.val;
    }

    TreeNode sub ;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null){
            return false;
        }
        sub = subRoot;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            boolean subtree2 = isSubtree2(poll, subRoot);
            if (subtree2){
                return true;
            }
            if (poll.left != null){
                queue.offer(poll.left);
            }
            if (poll.right != null){
                queue.offer(poll.right);
            }
        }
        return false;

    }

    public boolean isSubtree3(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null){
            return false;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root,paths);
        System.out.println(paths);

        List<Integer> paths1 = new ArrayList<>();
        traversal(subRoot,paths1);
        System.out.println(paths1);
        return false;

    }

    void traversal(TreeNode root,List<Integer> paths){
        if (root == null){
            return;
        }
        traversal(root.left,paths);
        paths.add(root.val);
        traversal(root.right,paths);
    }

    void traversal(TreeNode root,List<Integer> paths,List<String> temp){
        if (root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for (Integer integer : paths) {
                sb.append(integer).append("->");
            }
            sb.delete(sb.length()-2,sb.length()).append("END");
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


    public boolean isSubtree2(TreeNode root, TreeNode subRoot){
        if (root != null && subRoot != null){
            if (root.val == subRoot.val){
                if (isSubtree2(root.left,subRoot.left) && isSubtree2(root.right,subRoot.right)){
                    return true;
                }
                return false;
            }else{
                if (sub.equals(subRoot)){
                    if (isSubtree2(root.left,subRoot) || isSubtree2(root.right,subRoot)){
                        return true;
                    }
                }
                return false;
            }
        }
        if (root == null && subRoot == null){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(7);

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);

        boolean subtree = solution2.isSubtree(root, root1);
        System.out.println(subtree);
    }

    private List<Integer> levelOrder(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return list;
    }



}
