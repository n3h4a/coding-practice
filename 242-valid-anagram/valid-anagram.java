/*
 * Valid Anagram
 * Pattern : Hashing / Counting
 * Approach: One array of 26 counters: increment for letters of s, decrement
 *           for letters of t. They are anagrams only if every counter is 0.
 * Time    : O(n)
 * Space   : O(1) - fixed 26-letter alphabet
 *
 * Earlier approaches I tried:
 *   1. Sort both strings and compare     - O(n log n) time
 *   2. Two HashMaps of character counts  - O(n) time, more overhead
 *   3. Single int[26] counter (below)    - O(n) time, O(1) space
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
