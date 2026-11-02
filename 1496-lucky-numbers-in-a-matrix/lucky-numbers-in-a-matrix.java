/*
 * Lucky Numbers in a Matrix
 * Pattern : Matrix
 * Approach: For each row, find its minimum, then check whether it is also
 *           the maximum of its column.
 * Time    : O(m * n + m^2)
 * Space   : O(1) extra
 */
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> lucky = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            // Minimum of row i and the column it sits in.
            int min = Integer.MAX_VALUE;
            int col = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    col = j;
                }
            }

            // It must also be the largest value in that column.
            boolean isColumnMax = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][col] > min) {
                    isColumnMax = false;
                    break;
                }
            }

            if (isColumnMax) {
                lucky.add(min);
            }
        }
        return lucky;
    }
}
