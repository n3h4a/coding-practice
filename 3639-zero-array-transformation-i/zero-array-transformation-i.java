/*
 * Zero Array Transformation I
 * Pattern : Difference Array / Prefix Sum
 * Approach: Every query can decrement each index in its range at most once,
 *           so count how many queries cover each index (difference array +
 *           prefix sum). The array can be zeroed iff coverage >= nums[i]
 *           everywhere.
 * Time    : O(n + q)
 * Space   : O(n)
 */
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] query : queries) {
            diff[query[0]]++;
            diff[query[1] + 1]--;
        }

        int coverage = 0;
        for (int i = 0; i < n; i++) {
            coverage += diff[i];
            if (coverage < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
