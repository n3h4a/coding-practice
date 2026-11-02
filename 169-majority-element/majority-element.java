/*
 * Majority Element
 * Pattern : Boyer-Moore Voting
 * Approach: Keep a candidate and a counter. Matching elements vote for the
 *           candidate, others vote against it; when the counter hits 0 a
 *           new candidate is picked. The majority element always survives.
 * Time    : O(n)
 * Space   : O(1)
 *
 * Earlier approaches I tried, from slowest to fastest:
 *   1. Count every element with a nested loop          - O(n^2) time
 *   2. HashMap of counts                                - O(n) time, O(n) space
 *   3. Sort and return nums[n / 2]                      - O(n log n) time
 *   4. Boyer-Moore voting (below)                       - O(n) time, O(1) space
 */
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
