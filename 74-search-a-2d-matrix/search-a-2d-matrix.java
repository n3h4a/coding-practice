/*
 * Search a 2D Matrix
 * Pattern : Binary Search
 * Approach: Rows are sorted and each row starts after the previous one
 *           ends, so the matrix is one sorted array of m * n elements.
 *           Binary search over that virtual array; index k maps to
 *           (k / n, k % n).
 * Time    : O(log(m * n))
 * Space   : O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int left = 0;
        int right = matrix.length * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = matrix[mid / n][mid % n];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
