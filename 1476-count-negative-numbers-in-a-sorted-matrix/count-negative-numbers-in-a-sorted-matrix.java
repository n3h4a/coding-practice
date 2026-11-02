/*
 * Count Negative Numbers in a Sorted Matrix
 * Pattern : Matrix / Staircase Search
 * Approach: Start at the top-right corner. A negative value means
 *           everything below it in that column is negative too, so count
 *           them all and move left; otherwise move down.
 * Time    : O(m + n)
 * Space   : O(1)
 */
class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int row = 0;
        int col = grid[0].length - 1;
        int count = 0;

        while (row < rows && col >= 0) {
            if (grid[row][col] >= 0) {
                row++;
            } else {
                count += rows - row;
                col--;
            }
        }
        return count;
    }
}
