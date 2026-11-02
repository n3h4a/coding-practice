/*
 * Describe the Painting
 * Pattern : Difference Array / Line Sweep
 * Approach: Each segment adds its colour at `start` and removes it at `end`.
 *           Sweeping the sorted positions gives the mixed colour sum on
 *           every interval between consecutive positions; output the
 *           intervals that are painted (sum != 0).
 * Time    : O(n log n)
 * Space   : O(n)
 */
class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> changes = new TreeMap<>();
        for (int[] segment : segments) {
            changes.merge(segment[0], (long) segment[2], Long::sum);
            changes.merge(segment[1], (long) -segment[2], Long::sum);
        }

        List<List<Long>> result = new ArrayList<>();
        Integer previous = null;
        long colourSum = 0;

        for (Map.Entry<Integer, Long> change : changes.entrySet()) {
            int position = change.getKey();
            if (previous != null && colourSum != 0) {
                result.add(List.of((long) previous, (long) position, colourSum));
            }
            colourSum += change.getValue();
            previous = position;
        }
        return result;
    }
}
