class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {

        int n = nums.length;
        int[] diff = new int[n + 1];

        // Difference array
        for (int[] req : requests) {
            diff[req[0]]++;
            if (req[1] + 1 < n) {
                diff[req[1] + 1]--;
            }
        }

        // Prefix sum -> frequency of each index
        int[] freq = new int[n];
        freq[0] = diff[0];

        for (int i = 1; i < n; i++) {
            freq[i] = freq[i - 1] + diff[i];
        }

        Arrays.sort(freq);
        Arrays.sort(nums);

        long ans = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            ans = (ans + (long) freq[i] * nums[i]) % MOD;
        }

        return (int) ans;
    }
}