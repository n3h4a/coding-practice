class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int idx = 0; 
        if( n % 2 == 0 ){
            for( int x = 1 ; x <= n / 2 ; x++){
                ans[idx++] = x;
                ans[idx++] = -x;
            }
        } else {
            ans[idx++] = 0;
            for( int x = 1 ; x <= n / 2 ; x++){
                ans[idx++] = x;
                ans[idx++] = -x;
            }
        }
        return ans;
    }
}