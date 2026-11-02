/*
 * Find First and Last Position of Element in Sorted Array
 * Pattern : Binary Search
 * Approach: Run binary search twice. On a match, record the index and keep
 *           searching left (for the first position) or right (for the last).
 * Time    : O(log n)
 * Space   : O(1)
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = search(nums, target, true);
        if (first == -1) {
            return new int[] {-1, -1};
        }
        return new int[] {first, search(nums, target, false)};
    }

    private int search(int[] nums, int target, boolean findFirst) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
