/*
 * Find N Unique Integers Sum up to Zero
 * Pattern : Math / Construction
 * Approach: Add pairs (x, -x), which cancel out. If n is odd, the remaining
 *           slot is filled with 0 (Java arrays start as zeros).
 * Time    : O(n)
 * Space   : O(1) extra
 */
class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;

        for (int x = 1; x <= n / 2; x++) {
            result[index++] = x;
            result[index++] = -x;
        }
        // If n is odd, the last slot is already 0.
        return result;
    }
}
