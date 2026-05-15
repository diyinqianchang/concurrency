package com.abc.algo.array;

/**
 * @Author Administrator
 * @Date 2026/4/21 19:59
 * @Version 1.0
 *
 * 编写⼀个⾼效的算法来搜索 m x n 矩阵 matrix 中的⼀个⽬标值 target。该矩阵具有以下特性：每⾏的元
 * 素从左到右升序排列；每列的元素从上到下升序排列
 *
 */
public class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(solution2.searchMatrix2(matrix, 6));
    }

}
