package com.abc.algo.array;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2026/4/22 14:10
 * @Version 1.0
 */
public class NumMatrix {

    private int[][] preNums;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        preNums = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preNums[i][j] = preNums[i - 1][j] + preNums[i][j - 1] + matrix[i - 1][j - 1] - preNums[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preNums[row2 + 1][col2 + 1] - preNums[row1][col2 + 1] - preNums[row2 + 1][col1] + preNums[row1][col1];
    }

    public void print() {
        for (int i = 0; i < preNums.length; i++) {
            System.out.println(Arrays.toString(preNums[i]));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        numMatrix.print();

    }
}
