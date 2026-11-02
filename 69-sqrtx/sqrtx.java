/*
 * Sqrt(x)
 * Pattern : Binary Search
 * Approach: Binary search on the answer in [1, x]. `mid * mid` is computed
 *           as a long to avoid overflow. When the loop ends, `right` is the
 *           largest value whose square is <= x.
 * Time    : O(log x)
 * Space   : O(1)
 */
class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
