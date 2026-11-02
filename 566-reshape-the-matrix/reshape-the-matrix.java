/*
 * Reshape the Matrix
 * Pattern : Matrix
 * Approach: Reading the matrix row by row gives a flat index k; element k
 *           sits at (k / n, k % n) in the original and at (k / c, k % c)
 *           in the reshaped matrix. If m * n != r * c, return the original.
 * Time    : O(m * n)
 * Space   : O(r * c) for the result
 */
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] reshaped = new int[r][c];
        for (int k = 0; k < m * n; k++) {
            reshaped[k / c][k % c] = mat[k / n][k % n];
        }
        return reshaped;
    }
}
