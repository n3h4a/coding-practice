/*
 * Flipping an Image
 * Pattern : Matrix / Two Pointers
 * Approach: Flip and invert in a single pass: swap each pair of mirrored
 *           cells in a row and invert both (1 - value). The loop runs to
 *           the middle (inclusive) so the centre cell is inverted too.
 * Time    : O(n^2)
 * Space   : O(1)
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            int n = row.length;
            for (int j = 0; j < (n + 1) / 2; j++) {
                int mirror = n - 1 - j;
                int temp = row[j];
                row[j] = 1 - row[mirror];
                row[mirror] = 1 - temp;
            }
        }
        return image;
    }
}
