class Solution {

    public boolean checkWithDifferenceArrayTeq(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        // Apply the first k queries
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if (r + 1 < n) {
                diff[r + 1] -= val;
            }
        }

        // Build prefix sum and check
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];

            if (nums[i] > curr) {
                return false;
            }
        }

        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int q = queries.length;

        // Already a zero array
        boolean allZero = true;
        for (int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }

        if (allZero) {
            return 0;
        }

        int left = 1;
        int right = q;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (checkWithDifferenceArrayTeq(nums, queries, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}