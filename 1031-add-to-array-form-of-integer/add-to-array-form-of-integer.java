/*
 * Add to Array-Form of Integer
 * Pattern : Math / Array Simulation
 * Approach: Treat k itself as the carry. Add it to digits from right to
 *           left, keep the last digit, and carry the rest. Any carry left
 *           at the end adds extra leading digits.
 * Time    : O(n + log k)
 * Space   : O(1) extra (the output list aside)
 */
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = k;

        for (int i = num.length - 1; i >= 0; i--) {
            carry += num[i];
            result.add(carry % 10);
            carry /= 10;
        }
        while (carry > 0) {
            result.add(carry % 10);
            carry /= 10;
        }

        Collections.reverse(result);
        return result;
    }
}
