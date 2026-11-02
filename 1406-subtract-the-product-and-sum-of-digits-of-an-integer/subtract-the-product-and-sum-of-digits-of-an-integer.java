/*
 * Subtract the Product and Sum of Digits of an Integer
 * Pattern : Math
 * Approach: Peel digits off with % 10 and / 10, updating the sum and the
 *           product as we go.
 * Time    : O(log10 n)
 * Space   : O(1)
 */
class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return product - sum;
    }
}
