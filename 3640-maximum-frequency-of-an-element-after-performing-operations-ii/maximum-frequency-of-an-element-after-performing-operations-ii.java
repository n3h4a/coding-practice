/*
 * Maximum Frequency of an Element After Performing Operations II
 * Pattern : Difference Array / Line Sweep
 * Approach: Same idea as part I, but values go up to 10^9, so an array over
 *           the value range is too big. Store only the interesting points
 *           (range starts, range ends and the nums themselves) in a TreeMap
 *           and sweep over them in sorted order.
 * Time    : O(n log n)
 * Space   : O(n)
 */
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        TreeMap<Integer, Integer> diff = new TreeMap<>();
        Map<Integer, Integer> exact = new HashMap<>();

        for (int num : nums) {
            exact.merge(num, 1, Integer::sum);
            diff.merge(Math.max(num - k, 0), 1, Integer::sum);
            diff.merge(num + k + 1, -1, Integer::sum);
            diff.putIfAbsent(num, 0); // make sure every num is visited as a target
        }

        int best = 1;
        int canReach = 0;
        for (Map.Entry<Integer, Integer> point : diff.entrySet()) {
            canReach += point.getValue();
            int already = exact.getOrDefault(point.getKey(), 0);
            int converted = Math.min(canReach - already, numOperations);
            best = Math.max(best, already + converted);
        }
        return best;
    }
}
