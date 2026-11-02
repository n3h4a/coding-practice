/*
 * Find the Highest Altitude
 * Pattern : Prefix Sum
 * Approach: The altitude after each step is the prefix sum of the gains.
 *           Track its maximum, starting from altitude 0.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int highest = 0;

        for (int g : gain) {
            altitude += g;
            highest = Math.max(highest, altitude);
        }
        return highest;
    }
}
