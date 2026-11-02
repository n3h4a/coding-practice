/*
 * Find Numbers with Even Number of Digits
 * Pattern : Math
 * Approach: The number of digits of a positive number is
 *           floor(log10(num)) + 1. Count the numbers where it is even.
 * Time    : O(n)
 * Space   : O(1)
 */
class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (digitCount(num) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private int digitCount(int num) {
        num = Math.abs(num);
        if (num == 0) {
            return 1;
        }
        return (int) Math.log10(num) + 1;
    }
}
