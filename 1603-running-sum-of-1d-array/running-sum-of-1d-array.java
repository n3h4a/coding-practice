/*
 * Running Sum of 1d Array
 * Pattern : Prefix Sum
 * Approach: Build the prefix sum in place: each element adds the running
 *           total stored just before it.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
