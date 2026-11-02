/*
 * Count Commas in Range
 * Pattern : Math
 * Approach: Here n <= 10^5, so only numbers from 1,000 to n have a comma,
 *           and each has exactly one. That is max(0, n - 999) commas.
 * Time    : O(1)
 * Space   : O(1)
 */
class Solution {
    public int countCommas(int n) {
        return Math.max(0, n - 999);
    }
}
