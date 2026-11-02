/*
 * Car Pooling
 * Pattern : Difference Array / Line Sweep
 * Approach: Passengers get on at `from` (+p) and off at `to` (-p). Sum
 *           these changes in order of location; if the running total ever
 *           exceeds the capacity, the trips are impossible.
 * Time    : O(n log n)
 * Space   : O(n)
 */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> changes = new TreeMap<>();
        for (int[] trip : trips) {
            int passengers = trip[0];
            changes.merge(trip[1], passengers, Integer::sum);
            changes.merge(trip[2], -passengers, Integer::sum);
        }

        int inCar = 0;
        for (int change : changes.values()) {
            inCar += change;
            if (inCar > capacity) {
                return false;
            }
        }
        return true;
    }
}
