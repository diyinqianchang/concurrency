package com.abc.algo.array;

import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2026/4/21 20:11
 * @Version 1.0
 * 重塑矩阵
 */
public class Solution3 {


    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            res[i / c][i % c] = mat[i / n][i % n];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}, {5, 6}};
        int[][] res = new Solution3().matrixReshape(mat, 2, 3);
        System.out.println(Arrays.deepToString(res));
    }
}
