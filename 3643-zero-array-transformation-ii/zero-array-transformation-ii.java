/*
 * Zero Array Transformation II
 * Pattern : Binary Search on Answer + Difference Array
 * Approach: If the first k queries can zero the array, so can the first
 *           k + 1. That monotonic property lets us binary search for the
 *           smallest k; each check applies k queries with a difference
 *           array and verifies coverage >= nums[i] at every index.
 * Time    : O((n + q) log q)
 * Space   : O(n)
 */
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        if (canZero(nums, queries, 0)) {
            return 0;
        }

        int left = 1;
        int right = queries.length;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canZero(nums, queries, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    // Can the first k queries turn nums into all zeros?
    private boolean canZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            diff[queries[i][0]] += queries[i][2];
            diff[queries[i][1] + 1] -= queries[i][2];
        }

        int coverage = 0;
        for (int i = 0; i < n; i++) {
            coverage += diff[i];
            if (nums[i] > coverage) {
                return false;
            }
        }
        return true;
    }
}
