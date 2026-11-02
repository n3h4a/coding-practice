/*
 * Build Array from Permutation
 * Pattern : Array
 * Approach: Direct translation of the definition: ans[i] = nums[nums[i]].
 * Time    : O(n)
 * Space   : O(n) for the result
 */
class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
