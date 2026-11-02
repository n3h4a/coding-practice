/*
 * Set Mismatch
 * Pattern : Cyclic Sort
 * Approach: After cyclic sort, the one index i that does not hold i + 1
 *           holds the duplicate, and i + 1 is the missing number.
 * Time    : O(n)
 * Space   : O(1) extra
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        cyclicSort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[] {nums[i], i + 1};
            }
        }
        return new int[] {-1, -1};
    }

    // Cyclic sort: place every value v at index v - 1.
    private void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
