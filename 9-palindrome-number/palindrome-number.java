/*
 * Palindrome Number
 * Pattern : Math
 * Approach: Reverse only the second half of the digits and compare it with
 *           the first half. This avoids overflow and string conversion.
 *           Negatives and numbers ending in 0 (except 0) are never palindromes.
 * Time    : O(log10 n)
 * Space   : O(1)
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For an odd number of digits, the middle digit sits at the end of reversedHalf.
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
