/*
 * Longest Substring Without Repeating Characters
 * Pattern : Sliding Window
 * Approach: Expand the window with `right`. While the new character is
 *           already inside the window, shrink it from `left`. The window
 *           always holds distinct characters, so track its maximum size.
 * Time    : O(n) - each character enters and leaves the set at most once
 * Space   : O(k) - k = distinct characters in the window
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
