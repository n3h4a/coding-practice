class Solution {
    public int maxSubArray(int[] nums) {
        int currSubSum = nums[0];
        int maxSubSum = nums[0];
        if( nums.length == 0) return 0;
        for( int i = 1 ; i < nums.length ; i++){
            currSubSum = Math.max(nums[i] , currSubSum + nums[i]);
            maxSubSum = Math.max(maxSubSum , currSubSum);
        }
        return maxSubSum;
    }
}