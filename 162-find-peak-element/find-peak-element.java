/*
 * Find Peak Element
 * Pattern : Binary Search
 * Approach: If arr[mid] > arr[mid + 1] we are on a descending slope, so a
 *           peak exists at mid or to its left; otherwise one exists to the
 *           right. The range shrinks until it points at a peak.
 * Time    : O(log n)
 * Space   : O(1)
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
