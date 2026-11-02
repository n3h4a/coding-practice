/*
 * Find All Duplicates in an Array
 * Pattern : Cyclic Sort
 * Approach: Values are in [1, n], so cyclic sort puts each value at index
 *           value - 1. Afterwards, any index holding the wrong value holds
 *           a duplicate.
 * Time    : O(n) - every swap places at least one value correctly
 * Space   : O(1) extra
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        cyclicSort(nums);

        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicates.add(nums[i]);
            }
        }
        return duplicates;
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
