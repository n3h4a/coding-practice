/*
 * Search a 2D Matrix II
 * Pattern : Matrix / Staircase Search
 * Approach: Start at the top-right corner. If the value is smaller than the
 *           target, the whole row to the left is too small, so move down;
 *           if larger, the whole column below is too large, so move left.
 * Time    : O(m + n)
 * Space   : O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int value = matrix[row][col];
            if (value == target) {
                return true;
            } else if (value < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
