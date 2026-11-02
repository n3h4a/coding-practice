/*
 * My Calendar II
 * Pattern : Difference Array / Line Sweep
 * Approach: Store +1 at every start and -1 at every end in a sorted map.
 *           Sweeping the map gives the number of overlapping bookings at
 *           every point. If adding a booking ever makes it 3, undo it.
 * Time    : O(n) per booking (O(n^2) overall)
 * Space   : O(n)
 */
class MyCalendarTwo {
    private final TreeMap<Integer, Integer> events = new TreeMap<>();

    public MyCalendarTwo() {
    }

    public boolean book(int startTime, int endTime) {
        events.merge(startTime, 1, Integer::sum);
        events.merge(endTime, -1, Integer::sum);

        int active = 0;
        for (int change : events.values()) {
            active += change;
            if (active > 2) {
                // Triple booking: roll the change back.
                events.merge(startTime, -1, Integer::sum);
                events.merge(endTime, 1, Integer::sum);
                events.remove(startTime, 0);
                events.remove(endTime, 0);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */
