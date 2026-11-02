/*
 * Unique 3-Digit Even Numbers
 * Pattern : Hashing / Enumeration
 * Approach: Try every ordered triple of distinct positions (hundreds, tens,
 *           ones). Skip leading zeros and odd last digits, and let a set
 *           remove duplicates created by repeated digits.
 * Time    : O(n^3) - n <= 10, so at most 720 triples
 * Space   : O(1) - at most 450 distinct even 3-digit numbers
 */
class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> unique = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;               // no leading zero
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;     // each digit used once
                    if (digits[k] % 2 != 0) continue;   // must be even
                    unique.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }
        return unique.size();
    }
}
