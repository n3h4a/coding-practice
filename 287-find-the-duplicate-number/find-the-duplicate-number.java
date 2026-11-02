/*
 * Find the Duplicate Number
 * Pattern : Fast & Slow Pointers (Floyd's Cycle Detection)
 * Approach: Treat the array as a linked list where index i points to
 *           nums[i]. The duplicate value has two incoming edges, so it is
 *           the entrance of a cycle. Floyd's algorithm finds that entrance
 *           without modifying the array.
 * Time    : O(n)
 * Space   : O(1)
 *
 * Cyclic sort also finds it in O(n) / O(1), but it modifies the input,
 * which this problem forbids.
 */
class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: find a meeting point inside the cycle.
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: a pointer from the start and one from the meeting point
        // meet at the cycle entrance, which is the duplicate value.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
