/*
 * Shuffle the Array
 * Pattern : Array
 * Approach: Element i of the first half goes to 2i and element i of the
 *           second half goes to 2i + 1.
 * Time    : O(n)
 * Space   : O(n) for the result
 */
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }
        return result;
    }
}
