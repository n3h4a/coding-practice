/*
 * Determine Whether Matrix Can Be Obtained By Rotation
 * Pattern : Matrix
 * Approach: There are only 4 distinct rotations. Compare, rotate 90 degrees
 *           clockwise (cell (i, j) moves to (j, n - 1 - i)), and repeat.
 * Time    : O(n^2)
 * Space   : O(n^2) for the rotated copy
 */
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int turn = 0; turn < 4; turn++) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            mat = rotateClockwise(mat);
        }
        return false;
    }

    private int[][] rotateClockwise(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = mat[i][j];
            }
        }
        return rotated;
    }
}
