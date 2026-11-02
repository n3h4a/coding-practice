/*
 * Arranging Coins
 * Pattern : Binary Search
 * Approach: k complete rows need k(k + 1) / 2 coins. Binary search for the
 *           largest k whose requirement is <= n, using longs to avoid overflow.
 * Time    : O(log n)
 * Space   : O(1)
 */
class Solution {
    public int arrangeCoins(int n) {
        long left = 1;
        long right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coinsNeeded = mid * (mid + 1) / 2;
            if (coinsNeeded == n) {
                return (int) mid;
            } else if (coinsNeeded < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right;
    }
}
