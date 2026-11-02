/*
 * Merge Strings Alternately
 * Pattern : Two Pointers
 * Approach: Take one character from each word in turn; once a word runs
 *           out, the loop keeps appending the rest of the other one.
 * Time    : O(n + m)
 * Space   : O(n + m) for the result
 */
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder(word1.length() + word2.length());
        int i = 0;
        int j = 0;

        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) merged.append(word1.charAt(i++));
            if (j < word2.length()) merged.append(word2.charAt(j++));
        }
        return merged.toString();
    }
}
