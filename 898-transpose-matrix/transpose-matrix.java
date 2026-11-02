/*
 * Transpose Matrix
 * Pattern : Matrix
 * Approach: Create an n x m matrix and copy matrix[i][j] to result[j][i].
 * Time    : O(m * n)
 * Space   : O(m * n) for the result
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
