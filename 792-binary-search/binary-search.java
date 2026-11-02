/*
 * Binary Search
 * Pattern : Binary Search
 * Approach: Classic iterative binary search on a sorted array. `mid` is
 *           computed as left + (right - left) / 2 to avoid int overflow.
 * Time    : O(log n)
 * Space   : O(1)
 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
