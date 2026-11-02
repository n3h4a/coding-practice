/*
 * Maximum Score of Non-overlapping Intervals
 * Pattern : Dynamic Programming + Binary Search
 * Approach: Sort intervals by start. dp(i, quota) = best (weight, indices)
 *           using intervals from i onward with at most `quota` picks left.
 *           Either skip interval i, or take it and jump (binary search) to
 *           the first interval starting after it ends. Ties on weight are
 *           broken by the lexicographically smaller list of indices.
 * Time    : O(n log n) - at most 4 picks per interval, each with a binary search
 * Space   : O(n) - n * 4 memo entries
 */
class Solution {
    private record Result(long weight, List<Integer> selected) {}

    private record Interval(int left, int right, int weight, int originalIndex) {}

    private static final int MAX_PICKS = 4;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        List<Interval> sorted = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            List<Integer> in = intervals.get(i);
            sorted.add(new Interval(in.get(0), in.get(1), in.get(2), i));
        }
        sorted.sort(Comparator.comparingInt(Interval::left));

        Result[][] memo = new Result[sorted.size()][MAX_PICKS + 1];
        return dp(sorted, memo, 0, MAX_PICKS).selected().stream().mapToInt(Integer::intValue).toArray();
    }

    private Result dp(List<Interval> intervals, Result[][] memo, int i, int quota) {
        if (i == intervals.size() || quota == 0) {
            return new Result(0, List.of());
        }
        if (memo[i][quota] != null) {
            return memo[i][quota];
        }

        Result skip = dp(intervals, memo, i + 1, quota);

        Interval current = intervals.get(i);
        int next = firstStartingAfter(intervals, i + 1, current.right());
        Result rest = dp(intervals, memo, next, quota - 1);

        List<Integer> picked = new ArrayList<>(rest.selected());
        picked.add(current.originalIndex());
        Collections.sort(picked);
        Result take = new Result(current.weight() + rest.weight(), picked);

        boolean takeIsBetter = take.weight() > skip.weight()
                || (take.weight() == skip.weight() && compareLists(take.selected(), skip.selected()) < 0);
        return memo[i][quota] = takeIsBetter ? take : skip;
    }

    // Binary search for the first interval (from `from`) whose start is > boundary.
    private int firstStartingAfter(List<Interval> intervals, int from, int boundary) {
        int lo = from;
        int hi = intervals.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (intervals.get(mid).left() > boundary) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // Lexicographic comparison of two index lists.
    private int compareLists(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return Integer.compare(a.size(), b.size());
    }
}
