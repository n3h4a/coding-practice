class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {

        int maxNum = 0;

        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        int maxVal = maxNum + k;

        int[] diff = new int[maxVal + 2];

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            int l = Math.max(nums[i] - k, 0);
            int r = Math.min(nums[i] + k, maxVal);

            diff[l]++;
            diff[r + 1]--;
        }

        int result = 1;

        for (int target = 0; target <= maxVal; target++) {

            if (target > 0) {
                diff[target] += diff[target - 1];
            }

            int targetFreq = freq.getOrDefault(target, 0);

            int needConversion = diff[target] - targetFreq;

            int maxPossibleFreq = Math.min(needConversion, numOperations);

            result = Math.max(
                result,
                targetFreq + maxPossibleFreq
            );
        }

        return result;
    }
}