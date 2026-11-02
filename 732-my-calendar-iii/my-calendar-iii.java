/*
 * My Calendar III
 * Pattern : Difference Array / Line Sweep
 * Approach: Same sweep as My Calendar II: +1 at each start, -1 at each end
 *           in a sorted map. The running sum is the number of overlapping
 *           events, and its maximum is the answer (the max k-booking).
 * Time    : O(n) per booking (O(n^2) overall)
 * Space   : O(n)
 */
class MyCalendarThree {
    private final TreeMap<Integer, Integer> events = new TreeMap<>();

    public MyCalendarThree() {
    }

    public int book(int startTime, int endTime) {
        events.merge(startTime, 1, Integer::sum);
        events.merge(endTime, -1, Integer::sum);

        int active = 0;
        int maxOverlap = 0;
        for (int change : events.values()) {
            active += change;
            maxOverlap = Math.max(maxOverlap, active);
        }
        return maxOverlap;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
