/*
 * Maximum Absolute Sum of Any Subarray
 * Pattern : Kadane's Algorithm
 * Approach: Run Kadane twice at once: once for the largest subarray sum and
 *           once for the smallest (most negative). The answer is the larger
 *           of the two in absolute value.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);
            maxSum = Math.max(maxSum, maxEndingHere);
            minSum = Math.min(minSum, minEndingHere);
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}
