/*
 * Merge Sorted Array
 * Pattern : Two Pointers
 * Approach: Fill nums1 from the back. The larger of the two current tails
 *           goes into position k, so nothing in nums1 is overwritten before
 *           it is used. Leftover nums1 elements are already in place.
 * Time    : O(m + n)
 * Space   : O(1)
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
