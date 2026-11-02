/*
 * Number of Good Pairs
 * Pattern : Hashing / Counting
 * Approach: When a value is seen for the (c + 1)-th time, it forms a good
 *           pair with each of the c earlier copies, so add c to the answer.
 *           Values are in [1, 100], so a small array is enough.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] seen = new int[101];
        int pairs = 0;

        for (int num : nums) {
            pairs += seen[num];
            seen[num]++;
        }
        return pairs;
    }
}
