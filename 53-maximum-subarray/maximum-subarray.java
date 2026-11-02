/*
 * Maximum Subarray
 * Pattern : Kadane's Algorithm
 * Approach: At each index, either extend the best subarray ending at the
 *           previous index or start fresh from the current element. The
 *           answer is the best value seen at any index.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int bestEndingHere = nums[0];
        int best = nums[0];

        for (int i = 1; i < nums.length; i++) {
            bestEndingHere = Math.max(nums[i], bestEndingHere + nums[i]);
            best = Math.max(best, bestEndingHere);
        }

        return best;
    }
}
