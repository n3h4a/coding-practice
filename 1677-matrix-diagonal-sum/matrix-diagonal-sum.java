/*
 * Matrix Diagonal Sum
 * Pattern : Matrix
 * Approach: Row i contributes mat[i][i] and mat[i][n - 1 - i]. When n is
 *           odd, both diagonals share the centre cell, so subtract it once.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i] + mat[i][n - 1 - i];
        }
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }
        return sum;
    }
}
