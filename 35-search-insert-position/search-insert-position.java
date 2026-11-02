/*
 * Search Insert Position
 * Pattern : Binary Search
 * Approach: Standard binary search. If the target is missing, `left` ends at
 *           the first index whose value is greater than the target, which is
 *           exactly where it should be inserted.
 * Time    : O(log n)
 * Space   : O(1)
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
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

        return left;
    }
}
