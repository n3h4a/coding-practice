/*
 * Contains Duplicate
 * Pattern : Hashing
 * Approach: Add each number to a set; Set.add returns false if it was
 *           already there.
 * Time    : O(n)
 * Space   : O(n)
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}
