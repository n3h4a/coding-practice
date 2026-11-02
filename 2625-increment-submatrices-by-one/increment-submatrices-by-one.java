/*
 * Increment Submatrices by One
 * Pattern : Difference Array / Prefix Sum
 * Approach: Treat every row as its own 1-D difference array: a query adds
 *           +1 at col1 and -1 at col2 + 1 for each of its rows. A prefix
 *           sum along each row then produces the final matrix.
 * Time    : O(q * n + n^2)
 * Space   : O(1) extra (the result matrix aside)
 *
 * A full 2-D difference array (4 corner updates per query) would make each
 * query O(1), for O(q + n^2) overall.
 */
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for (int[] q : queries) {
            int row1 = q[0], col1 = q[1], row2 = q[2], col2 = q[3];
            for (int i = row1; i <= row2; i++) {
                mat[i][col1]++;
                if (col2 + 1 < n) {
                    mat[i][col2 + 1]--;
                }
            }
        }

        for (int[] row : mat) {
            for (int j = 1; j < n; j++) {
                row[j] += row[j - 1];
            }
        }
        return mat;
    }
}
