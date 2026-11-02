/*
 * Concatenation of Array
 * Pattern : Array
 * Approach: Copy each element to index i and to index i + n.
 * Time    : O(n)
 * Space   : O(n) for the result
 */
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}
