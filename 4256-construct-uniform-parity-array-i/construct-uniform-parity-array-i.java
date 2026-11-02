/*
 * Construct Uniform Parity Array I
 * Pattern : Math / Parity
 * Approach: The answer is always true:
 *           - If every number is even, keep them all -> all even.
 *           - Otherwise some number o is odd. Keep every odd number, and
 *             replace each even number e with e - o, which is odd
 *             (even - odd = odd) -> all odd.
 *           With n = 1 the single number is trivially uniform.
 * Time    : O(1)
 * Space   : O(1)
 */
class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}
