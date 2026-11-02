/*
 * Finding 3-Digit Even Numbers
 * Pattern : Counting / Enumeration
 * Approach: Instead of trying every triple of digits (O(n^3)), try every
 *           even number from 100 to 998 and check whether the available
 *           digit counts can build it.
 * Time    : O(n + 450)
 * Space   : O(1)
 *
 * First attempt: three nested loops over the digit indices with a HashSet
 * to remove duplicates - O(n^3) time.
 */
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] available = new int[10];
        for (int d : digits) {
            available[d]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int num = 100; num < 1000; num += 2) {
            if (canBuild(num, available)) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean canBuild(int num, int[] available) {
        int[] needed = new int[10];
        needed[num / 100]++;
        needed[num / 10 % 10]++;
        needed[num % 10]++;
        for (int d = 0; d < 10; d++) {
            if (needed[d] > available[d]) {
                return false;
            }
        }
        return true;
    }
}
