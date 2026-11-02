/*
 * Search in Rotated Sorted Array II
 * Pattern : Binary Search
 * Approach: Same idea as the version without duplicates: find the pivot,
 *           then binary search the correct half. When start, mid and end
 *           hold equal values we cannot tell which side is sorted, so we
 *           shrink both ends by one (after checking they are not the pivot).
 * Time    : O(log n) average - O(n) worst case with many duplicates
 * Space   : O(1)
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);

        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if (nums[pivot] == target) {
            return true;
        }
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    private boolean binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // mid is the pivot
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // mid - 1 is the pivot
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                // Duplicates hide the sorted half: skip both ends, but check them first.
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                // Left half is sorted, so the pivot is to the right.
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
