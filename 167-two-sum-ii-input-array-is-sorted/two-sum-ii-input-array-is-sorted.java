/*
 * Two Sum II - Input Array Is Sorted
 * Pattern : Two Pointers
 * Approach: Start at both ends. If the sum is too small, move the left
 *           pointer right; if too large, move the right pointer left.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1}; // 1-indexed answer
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};
    }
}
