/*
 * Special Array With X Elements Greater Than or Equal X
 * Pattern : Counting / Prefix Sum
 * Approach: x can be at most n, so bucket values into counts[0..n] (values
 *           above n go into bucket n). Scanning from n down, the running
 *           total is the number of elements >= x; return x when they match.
 * Time    : O(n)
 * Space   : O(n)
 */
class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n + 1];

        for (int num : nums) {
            counts[Math.min(num, n)]++;
        }

        int atLeastX = 0;
        for (int x = n; x > 0; x--) {
            atLeastX += counts[x];
            if (atLeastX == x) {
                return x;
            }
        }
        return -1;
    }
}
