/*
 * Spiral Matrix
 * Pattern : Matrix
 * Approach: Keep four boundaries (top, bottom, left, right). Walk one edge,
 *           move that boundary inward, and stop as soon as the boundaries cross.
 * Time    : O(m * n)
 * Space   : O(1) extra (the output list aside)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int col = left; col <= right; col++) result.add(matrix[top][col]);
            if (++top > bottom) break;

            for (int row = top; row <= bottom; row++) result.add(matrix[row][right]);
            if (left > --right) break;

            for (int col = right; col >= left; col--) result.add(matrix[bottom][col]);
            if (top > --bottom) break;

            for (int row = bottom; row >= top; row--) result.add(matrix[row][left]);
            if (++left > right) break;
        }

        return result;
    }
}
