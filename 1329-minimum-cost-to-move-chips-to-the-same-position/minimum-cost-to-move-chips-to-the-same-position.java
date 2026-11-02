/*
 * Minimum Cost to Move Chips to The Same Position
 * Pattern : Math / Greedy
 * Approach: Moving by 2 is free, so every chip can reach any position of
 *           the same parity at no cost. Only switching parity costs 1, so
 *           move the smaller group (odd or even) to the other.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;

        for (int pos : position) {
            if (pos % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }
}
