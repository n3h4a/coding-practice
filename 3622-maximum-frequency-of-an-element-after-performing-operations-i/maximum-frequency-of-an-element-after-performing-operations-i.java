/*
 * Maximum Frequency of an Element After Performing Operations I
 * Pattern : Difference Array / Prefix Sum
 * Approach: Each num can be turned into any value in [num - k, num + k].
 *           A difference array over the value range counts, for every
 *           target, how many nums can reach it. Elements already equal to
 *           the target are free; the others cost one operation each, capped
 *           by numOperations.
 * Time    : O(n + maxValue + k)
 * Space   : O(maxValue + k)
 */
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int maxValue = maxNum + k;

        int[] reach = new int[maxValue + 2];
        int[] exact = new int[maxValue + 1];
        for (int num : nums) {
            exact[num]++;
            reach[Math.max(num - k, 0)]++;
            reach[Math.min(num + k, maxValue) + 1]--;
        }

        int best = 1;
        int canReach = 0;
        for (int target = 0; target <= maxValue; target++) {
            canReach += reach[target];
            int converted = Math.min(canReach - exact[target], numOperations);
            best = Math.max(best, exact[target] + converted);
        }
        return best;
    }
}
