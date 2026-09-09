class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        totalCommas += Math.max(0L, n - 1000L + 1);
        totalCommas += Math.max(0L, n - 1000000L + 1);
        totalCommas += Math.max(0L, n - 1000000000L + 1);
        totalCommas += Math.max(0L, n - 1000000000000L + 1);
        totalCommas += Math.max(0L, n - 1000000000000000L + 1);
        totalCommas += Math.max(0L, n - 1000000000000000000L + 1);

        return totalCommas;
    }
}