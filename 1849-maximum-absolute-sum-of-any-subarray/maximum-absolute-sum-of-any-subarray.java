class Solution {
    public int maxAbsoluteSum(int[] nums) {
        if( nums.length == 0) return 0;
        int currmax = nums[0];
        int currmin = nums[0];
        int maxsum = nums[0];
        int minsum = nums[0];
        for( int i = 1 ; i < nums.length ; i++){
            currmax = Math.max(nums[i], currmax + nums[i]);
            currmin = Math.min(nums[i], currmin + nums[i]);

            maxsum = Math.max(maxsum, currmax);
            minsum = Math.min(minsum, currmin);
        }
        return Math.max(Math.abs(maxsum) , Math.abs(minsum));
    }
}