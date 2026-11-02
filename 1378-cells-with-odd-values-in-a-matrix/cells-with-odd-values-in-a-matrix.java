/*
 * Cells with Odd Values in a Matrix
 * Pattern : Matrix / Counting
 * Approach: Instead of building the matrix, count how many times each row
 *           and each column is incremented. Cell (i, j) holds
 *           rows[i] + cols[j], so just count the odd sums.
 * Time    : O(m * n + indices)
 * Space   : O(m + n)
 */
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[i] + cols[j]) % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
