/*
 * Find All Numbers Disappeared in an Array
 * Pattern : Cyclic Sort
 * Approach: Cyclic sort places each value v at index v - 1. Any index i that
 *           does not hold i + 1 afterwards means i + 1 is missing.
 * Time    : O(n)
 * Space   : O(1) extra
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        cyclicSort(nums);

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missing.add(i + 1);
            }
        }
        return missing;
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
