/*
 * Plus One
 * Pattern : Math / Array Simulation
 * Approach: Walk from the last digit. A digit below 9 absorbs the carry and
 *           we are done; a 9 becomes 0 and the carry moves left. If every
 *           digit was 9, the answer is 1 followed by zeros.
 * Time    : O(n)
 * Space   : O(1) (O(n) only in the all-nines case)
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
