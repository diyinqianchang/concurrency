package com.abc.algo.backtrack;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2022/3/1 0:11
 * @Version 1.0
 */
public class BackTrack {



    List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        backtrack(nums,track,res);
        return res;
    }

    void backtrack(int[] nums,LinkedList<Integer> track,List<List<Integer>> res){
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backtrack(nums,track,res);
            track.removeLast();
        }
    }


    public List<List<Integer>> permute2(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        backtrack2(nums,track,res,new boolean[nums.length]);
        return res;
    }
    void backtrack2(int[] nums,LinkedList<Integer> track,List<List<Integer>> res,
                    boolean[] selected){
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        Set<Integer> duplicated = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (selected[i] || duplicated.contains(nums[i])){
                continue;
            }
            duplicated.add(nums[i]);
            selected[i] = true;
            track.add(nums[i]);
            backtrack2(nums,track,res,selected);
            selected[i] = false;
            track.removeLast();
        }
    }

    public List<List<Integer>> permute3(int[] nums,int target){
        List<Integer> track = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        int total = 0;
        backtrack3(track,target,total,nums,res);
        return res;
    }

    void backtrack3(List<Integer>state,int target,int total,int[] choices,List<List<Integer>> res){

        if (total == target){
            res.add(new LinkedList<>(state));
            return;
        }
        for (int i = 0; i < choices.length; i++) {
            if (total + choices[i] > target){
                continue;
            }
            state.add(choices[i]);
            backtrack3(state,target,total+choices[i],choices,res);
            state.remove(state.size()-1);
        }

    }

    public List<List<Integer>> permute4(int[] nums,int target){
        List<Integer> track = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        int start = 0;
        backtrack4(track,target,start,nums,res);
        return res;
    }

    void backtrack4(List<Integer>state,int target,int start,int[] choices,List<List<Integer>> res){
        if (target == 0){
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = start; i < choices.length; i++) {
            if (target < choices[i]){
                continue;
            }
            state.add(choices[i]);
            backtrack4(state,target-choices[i],i,choices,res);
            state.remove(state.size()-1);
        }
    }

    public static int arrangeCoins(int n) {

        int i = 1;
        while (n >= i){
            n -= i;
            i++;
        }
        return i-1;
    }



    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> state = new ArrayList<>();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++){
            chars[i] = '.';
        }
        for (int j = 0; j < n; j++){
            state.add(new String(chars));
        }
        backtrack6(0,state,res);
//        backtrack5(0,n,state,res,new boolean[n],new boolean[2*n-1],new boolean[2*n-1]);
        return res;
    }


    void backtrack5(int row, int n, List<String> state, List<List<String>> res,
                    boolean[] cols, boolean[] diags1, boolean[] diags2) {
        if (row == n) {
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = 0; i < n; i++) {
            int diag1 = row - i + n - 1;
            int diag2 = row + i;
            if (cols[i] || diags1[diag1] || diags2[diag2]) {
                continue;
            }
            cols[i] = diags1[diag1] = diags2[diag2] = true;
            state.add(createRow(n, i));
            backtrack5(row + 1, n, state, res, cols, diags1, diags2);
            cols[i] = diags1[diag1] = diags2[diag2] = false;
            state.remove(state.size() - 1);
        }
    }
    String createRow(int n,int i){
        char[] chars = new char[n];
        Arrays.fill(chars,'.');
        chars[i] = 'Q';
        return new String(chars);
    }

    void backtrack6(int row,List<String> state, List<List<String>> res) {
        if (row == state.size()) {
            res.add(new ArrayList<>(state));
            return;
        }
        int n = state.get(row).length();
        for (int col = 0; col < n; col++){
            if (!isValid(state,row,col)){
                continue;
            }
            char[] chars = state.get(row).toCharArray();
            chars[col] = 'Q';
            state.set(row,new String(chars));
            backtrack6(row+1,state,res);
            chars[col] = '.';
            state.set(row,new String(chars));
        }
    }

    boolean isValid(List<String> state,int row,int col){
        int n = state.size();
        for (int i = 0; i < row; i++) {
            if (state.get(i).charAt(col) == 'Q'){
                return false;
            }
        }
        for (int i = row-1,j = col+1; i >= 0 && j < n; i--,j++) {
            if (state.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        for (int i = row-1,j = col-1; i >= 0 && j >= 0; i--,j--) {
            if (state.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[] nums = {3,4,5};
        BackTrack backTrack = new BackTrack();
//        List<List<String>> lists = backTrack.solveNQueens(4);
//        System.out.println(lists);
//        List<List<Integer>> permute = backTrack.permute(nums);
//        System.out.println(permute);
        List<List<Integer>> permute2 = backTrack.permute4(nums,9);
        System.out.println(permute2);


    }
}
