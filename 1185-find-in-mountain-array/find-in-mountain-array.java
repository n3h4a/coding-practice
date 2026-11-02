/*
 * Find in Mountain Array
 * Pattern : Binary Search
 * Approach: 1) Binary search for the peak.
 *           2) Search the ascending half; the first match there has the
 *              smaller index.
 *           3) If not found, search the descending half with the
 *              comparisons reversed (order-agnostic binary search).
 * Time    : O(log n) - about 3 log n calls to get()
 * Space   : O(1)
 */

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);

        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    private int findPeak(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int binarySearch(MountainArray mountainArr, int target, int start, int end, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }
            boolean goLeft = ascending ? target < value : target > value;
            if (goLeft) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
