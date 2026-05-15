package com.abc.algo.backtrack;

import com.abc.algo.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2025/9/27 10:46
 * @Version 1.0
 */
public class TrackFrame {

    boolean isSolution(List<TreeNode> state){
        return !state.isEmpty() && state.get(state.size()-1).val == 7;
    }

    void recordSolution(List<TreeNode> state,List<List<TreeNode>> res){
        res.add(new ArrayList<>(state));
    }

    boolean isValid(List<TreeNode> state,TreeNode choice){
        return choice != null && choice.val != 3;
    }

    void makeChoice(List<TreeNode> state,TreeNode choice){
        state.add(choice);
    }

    void unMakeChoice(List<TreeNode> state,TreeNode choice){
        state.remove(state.size()-1);
    }


    void backtrack(List<TreeNode> state,List<TreeNode> choices,List<List<TreeNode>> res){

        if (isSolution(state)){
            recordSolution(state, res);
            return;
        }
        for (TreeNode choice : choices){
            if (!isValid(state, choice)){
               continue;
            }
            makeChoice(state, choice);
            backtrack(state, Arrays.asList(choice.left, choice.right), res);
            unMakeChoice(state, choice);
        }
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
        TrackFrame trackFrame = new TrackFrame();
        List<List<TreeNode>> paths = new ArrayList<>();
        trackFrame.backtrack(new ArrayList<>(), Arrays.asList(root), paths);
        System.out.println(paths);
    }
}
