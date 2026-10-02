class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        
        int n = nums.length;
        int[] diff = new int[n + 1];
        for(int[] query : queries){
            int L = query[0];
            int R = query[1];
            diff[L] += 1;
            diff[R+1] -= 1;

    }
    int curr = 0 ;
    for( int i = 0 ; i < n ; i ++){
        curr += diff[i];
        if (curr < nums[i]){
        return false;
    }
    }
    return true ; 
}
}