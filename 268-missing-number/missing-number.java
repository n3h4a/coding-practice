/*
 * Missing Number
 * Pattern : Cyclic Sort
 * Approach: Values are in [0, n], so cyclic sort places each value v at
 *           index v (the value n has no slot and is left wherever it is).
 *           The first index i with nums[i] != i is the missing number; if
 *           every index matches, n is missing.
 * Time    : O(n)
 * Space   : O(1)
 *
 * Alternatives: n(n + 1) / 2 minus the sum, or XOR of all indices and
 * values - both O(n) time, O(1) space.
 */
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i];
            if (correct < nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index) {
                return index;
            }
        }
        return nums.length;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
