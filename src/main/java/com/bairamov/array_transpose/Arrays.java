package com.bairamov.array_transpose;

/*
Implement the matrix transposition function.
Matrices are presented as arrays of arrays, where internal arrays are rows of the matrix.
There are different ways to transpose a matrix:
    1) reflect the array over its main diagonal (which runs from top-left to bottom-right);
    2) write the rows of the original matrix as columns of the new one;
    3) write the columns of the original matrix as rows of the new one.
*/

public class Arrays {
    public static Object[][] transpose(Object[][] matrix) {
        int n = matrix.length;

        if (n == 0) {
            return matrix;
        }

        int m = matrix[0].length;
        Object[][] result = new Object[m][n];

        for (int i = 0; i < m; i++) {
            result[i] = new Object[n];
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix[j][i];
            }
        }

        return result;
    }
}
