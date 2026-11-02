/*
 * First Missing Positive
 * Pattern : Cyclic Sort
 * Approach: The answer is always in [1, n + 1]. Cyclic sort every value v
 *           in [1, n] to index v - 1 and ignore everything else (negatives,
 *           zeros, values > n). The first index i not holding i + 1 gives
 *           the answer; if all match, it is n + 1.
 * Time    : O(n) - every swap puts one value in its final place
 * Space   : O(1)
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        for (int index = 0; index < n; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
