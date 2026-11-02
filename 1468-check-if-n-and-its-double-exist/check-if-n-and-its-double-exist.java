/*
 * Check If N and Its Double Exist
 * Pattern : Binary Search
 * Approach: Sort the array, then binary search for 2 * arr[i] for every i.
 *           A match at the same index (the value 0) does not count, so we
 *           keep searching to the right.
 * Time    : O(n log n)
 * Space   : O(1) extra
 *
 * A HashSet version (check 2x and x / 2 against values already seen) runs
 * in O(n) time with O(n) space.
 */
class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int target = 2 * arr[i];
            int left = 0;
            int right = arr.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target && mid != i) {
                    return true;
                } else if (arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
