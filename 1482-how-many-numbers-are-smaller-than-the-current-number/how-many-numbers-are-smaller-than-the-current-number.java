/*
 * How Many Numbers Are Smaller Than the Current Number
 * Pattern : Counting / Prefix Sum
 * Approach: Values are in [0, 100]. Count how often each value occurs, then
 *           take a prefix sum: the count of numbers smaller than v is the
 *           sum of the counts of 0..v-1.
 * Time    : O(n + 101)
 * Space   : O(101)
 *
 * First attempt: compare every pair with a nested loop - O(n^2) time.
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[102];
        for (int num : nums) {
            count[num + 1]++;
        }
        for (int v = 1; v < count.length; v++) {
            count[v] += count[v - 1];
        }

        // count[v] now holds how many numbers are smaller than v.
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = count[nums[i]];
        }
        return result;
    }
}
