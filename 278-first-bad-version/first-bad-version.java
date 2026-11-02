/*
 * First Bad Version
 * Pattern : Binary Search
 * Approach: Versions are good...good bad...bad. When mid is bad, it is a
 *           candidate answer and we keep searching to the left for an
 *           earlier bad version; otherwise search to the right.
 * Time    : O(log n) API calls
 * Space   : O(1)
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int firstBad = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                firstBad = mid;     // possible answer
                right = mid - 1;    // look for an earlier bad version
            } else {
                left = mid + 1;
            }
        }

        return firstBad;
    }
}
