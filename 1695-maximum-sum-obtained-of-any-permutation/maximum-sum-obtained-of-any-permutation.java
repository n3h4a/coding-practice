/*
 * Maximum Sum Obtained of Any Permutation
 * Pattern : Difference Array / Greedy
 * Approach: Use a difference array to count how many requests cover each
 *           index. Greedily pair the most-requested index with the largest
 *           number by sorting both arrays and multiplying position-wise.
 * Time    : O(n log n + requests)
 * Space   : O(n)
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] freq = new int[n + 1];

        for (int[] request : requests) {
            freq[request[0]]++;
            freq[request[1] + 1]--;
        }
        for (int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
        }

        int[] coverage = Arrays.copyOf(freq, n);
        Arrays.sort(coverage);
        Arrays.sort(nums);

        long total = 0;
        for (int i = 0; i < n; i++) {
            total = (total + (long) coverage[i] * nums[i]) % MOD;
        }
        return (int) total;
    }
}
