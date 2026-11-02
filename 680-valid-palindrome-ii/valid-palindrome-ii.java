/*
 * Valid Palindrome II
 * Pattern : Two Pointers
 * Approach: Compare from both ends. At the first mismatch we may delete one
 *           character, so the string is valid if skipping either the left
 *           or the right character leaves a palindrome.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
