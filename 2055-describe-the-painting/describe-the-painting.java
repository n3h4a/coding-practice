import java.util.*;

class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {

        TreeMap<Integer, Long> events = new TreeMap<>();

        // Difference map
        for (int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];
            int color = segment[2];

            events.put(start, events.getOrDefault(start, 0L) + color);
            events.put(end, events.getOrDefault(end, 0L) - color);
        }

        List<List<Long>> result = new ArrayList<>();

        Integer prev = null;
        long currColor = 0;

        for (Map.Entry<Integer, Long> event : events.entrySet()) {

            int position = event.getKey();
            long change = event.getValue();

            // Interval from prev to current position
            if (prev != null && prev != position && currColor != 0) {
                result.add(Arrays.asList(
                        (long) prev,
                        (long) position,
                        currColor
                ));
            }

            // Apply current event
            currColor += change;
            prev = position;
        }

        return result;
    }
}