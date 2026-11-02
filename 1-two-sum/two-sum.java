/*
 * Two Sum
 * Pattern : Hashing
 * Approach: Single pass. For each number, check whether its complement
 *           (target - num) has already been seen. The map stores
 *           value -> index so the answer can be returned immediately.
 * Time    : O(n)
 * Space   : O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexByValue.containsKey(complement)) {
                return new int[] {indexByValue.get(complement), i};
            }
            indexByValue.put(nums[i], i);
        }

        return new int[] {};
    }
}
