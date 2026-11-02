/*
 * Remove Element
 * Pattern : Two Pointers
 * Approach: When nums[i] equals val, overwrite it with the last element and
 *           shrink the array. Order does not matter, so this keeps the
 *           number of writes minimal.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[--n];
            } else {
                i++;
            }
        }

        return n;
    }
}
