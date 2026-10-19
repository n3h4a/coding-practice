class Solution {
    public int removeElement(int[] nums, int val) {
            int i = 0, n = nums.length;
                while (i < n){
                    if (nums[i] == val ){
                        n--;
                        nums[i] = nums[n];
                        } else {
                            i++;
                        }
                }
        return n;
    }
}