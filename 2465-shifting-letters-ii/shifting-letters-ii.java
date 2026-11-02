/*
 * Shifting Letters II
 * Pattern : Difference Array / Prefix Sum
 * Approach: Each shift adds +1 (forward) or -1 (backward) to a range. Record
 *           it in a difference array, take a prefix sum to get each
 *           character's net shift, and apply it modulo 26.
 * Time    : O(n + shifts)
 * Space   : O(n)
 */
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];

        for (int[] shift : shifts) {
            int delta = shift[2] == 1 ? 1 : -1;
            diff[shift[0]] += delta;
            diff[shift[1] + 1] -= delta;
        }

        char[] chars = s.toCharArray();
        int netShift = 0;
        for (int i = 0; i < n; i++) {
            netShift += diff[i];
            int offset = ((chars[i] - 'a' + netShift) % 26 + 26) % 26; // handle negatives
            chars[i] = (char) ('a' + offset);
        }
        return new String(chars);
    }
}
