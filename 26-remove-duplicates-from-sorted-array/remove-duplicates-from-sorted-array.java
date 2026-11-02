/*
 * Remove Duplicates from Sorted Array
 * Pattern : Two Pointers
 * Approach: `last` marks the end of the unique prefix. Because the array is
 *           sorted, a value is new exactly when it differs from nums[last].
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int last = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[last]) {
                nums[++last] = nums[i];
            }
        }

        return last + 1;
    }
}
