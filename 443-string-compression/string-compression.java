/*
 * String Compression
 * Pattern : Two Pointers
 * Approach: `read` scans each run of equal characters while `write` writes
 *           the character followed by the run length (if > 1) in place.
 *           The write pointer never passes the read pointer.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char current = chars[read];
            int runLength = 0;
            while (read < chars.length && chars[read] == current) {
                runLength++;
                read++;
            }

            chars[write++] = current;
            if (runLength > 1) {
                for (char digit : Integer.toString(runLength).toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }

        return write;
    }
}
