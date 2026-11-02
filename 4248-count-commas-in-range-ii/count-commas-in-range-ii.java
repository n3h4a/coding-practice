/*
 * Count Commas in Range II
 * Pattern : Math
 * Approach: Every number >= 1,000 has a first comma, every number
 *           >= 1,000,000 has a second one, and so on. So for each
 *           threshold 10^3, 10^6, ... <= n, add the count of numbers in
 *           [threshold, n], which is n - threshold + 1.
 * Time    : O(log_1000 n)
 * Space   : O(1)
 *
 * How I got here:
 *   1. Hard-coded the six thresholds up to 10^18.
 *   2. Counted numbers per block [1000^k, 1000^(k+1)) times k commas.
 *   3. Noticed each threshold contributes independently (below).
 */
class Solution {
    public long countCommas(long n) {
        long commas = 0;
        for (long threshold = 1000; threshold <= n; threshold *= 1000) {
            commas += n - threshold + 1;
            if (threshold > Long.MAX_VALUE / 1000) {
                break; // the next threshold would overflow
            }
        }
        return commas;
    }
}
