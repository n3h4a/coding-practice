class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0 ; 
        int r = arr.length;
        while( l < r) {
            int m = (l + r) / 2;
            if(arr[m] - 1 - m < k){
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l + k;
    }
}