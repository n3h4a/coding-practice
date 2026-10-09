class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for( int i = 0 ; i < arr.length ; i++){
        int left = 0;
        int right = arr.length - 1;
        int target = 2 * arr[i];
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                if( mid != i){
                    return true;
                }
                left = mid + 1;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }

        }
    }
    return false;
    }
}