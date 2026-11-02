/*
 * Kth Missing Positive Number
 * Pattern : Binary Search
 * Approach: Before index i, arr[i] - 1 - i positive numbers are missing.
 *           This count only grows, so binary search for the first index
 *           where it reaches k. The answer is then that index + k.
 * Time    : O(log n)
 * Space   : O(1)
 */
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int missingBefore = arr[mid] - 1 - mid;
            if (missingBefore < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left + k;
    }
}
