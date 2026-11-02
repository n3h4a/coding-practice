/*
 * Longest Common Prefix
 * Pattern : Strings / Sorting
 * Approach: After sorting, the first and last strings are the most different
 *           ones, so their common prefix is the common prefix of all strings.
 * Time    : O(n * m log n) - sorting compares strings of length up to m
 * Space   : O(1) extra (ignoring the sort)
 *
 * Also tried: vertical scanning (compare column by column), see
 * longestCommonPrefixVertical below - O(n * m) time without sorting.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int limit = Math.min(first.length(), last.length());

        for (int i = 0; i < limit; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return first.substring(0, i);
            }
        }
        return first.substring(0, limit);
    }

    // Alternative: check character i of every string before moving to i + 1.
    public String longestCommonPrefixVertical(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                if (i == s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    return s.substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
