/*
 * Contains Duplicate II
 * Pattern : Hashing
 * Approach: Remember the last index of every value. A repeat is a match if
 *           it is at most k positions after the previous occurrence.
 * Time    : O(n)
 * Space   : O(n)
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer previous = lastIndex.put(nums[i], i);
            if (previous != null && i - previous <= k) {
                return true;
            }
        }

        return false;
    }
}
