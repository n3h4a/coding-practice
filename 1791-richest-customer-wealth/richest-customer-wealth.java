/*
 * Richest Customer Wealth
 * Pattern : Matrix
 * Approach: Sum each customer's row and keep the largest total.
 * Time    : O(m * n)
 * Space   : O(1)
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        int richest = 0;
        for (int[] customer : accounts) {
            int wealth = 0;
            for (int money : customer) {
                wealth += money;
            }
            richest = Math.max(richest, wealth);
        }
        return richest;
    }
}
