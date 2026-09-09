class Solution {
    public long countCommas(long n) {
         /* long totalCommas = 0;
        totalCommas += Math.max(0L, n - 1000L + 1);
        totalCommas += Math.max(0L, n - 1000000L + 1);
        totalCommas += Math.max(0L, n - 1000000000L + 1);
        totalCommas += Math.max(0L, n - 1000000000000L + 1);
        totalCommas += Math.max(0L, n - 1000000000000000L + 1);
        totalCommas += Math.max(0L, n - 1000000000000000000L + 1);

        return totalCommas;   */


                /*    long result = 0;
                    long lower = 1000;
                    long commas =  1;
                    while( lower <= n){
                        long upper = (lower * 1000) - 1;
                        if( upper > n ) {
                            upper = n;
                        }
                        long countNos = upper - lower + 1;
                        result += (countNos * commas);
                        lower *= 1000;
                        commas++;
                    }
                    return result;   */



                                long result = 0;
                                long start = 1000;

                                while( start <= n){
                                    result += n - start + 1;
                                    start *= 1000;
                                }
                                return result;



    }
}