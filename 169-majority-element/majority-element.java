class Solution {
    public int majorityElement(int[] nums) {
      /*  int n = nums.length;
        for(int num : nums){
            int count = 0;
            for( int i : nums){
                if(i == num){
                    count++;
                }
            }
            if ( count > n /2){
                return num;
            }
        }
        return -1;    */

                 /*   HashMap<Integer , Integer> count = new HashMap <>();
                    int res = 0 ; int maxCount = 0;
                    for( int num : nums){
                        count.put(num, count.getOrDefault(num , 0) + 1);
                        if(count.get(num) > maxCount){
                            res = num;
                            maxCount = count.get(num);
                        }
                    }
                    return res;       */


                                Arrays.sort(nums);
                                return nums[nums.length / 2];





    }
}