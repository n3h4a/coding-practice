/*
 * Maximum Population Year
 * Pattern : Difference Array / Line Sweep
 * Approach: Years are limited to [1950, 2050], so use a difference array:
 *           +1 at the birth year, -1 at the death year (a person is not
 *           alive in their death year). A prefix sum gives the population
 *           of each year; return the first year with the maximum.
 * Time    : O(n + 101)
 * Space   : O(101)
 *
 * Also tried: a general line sweep that sorts (year, +1/-1) events - see
 * maximumPopulationSweep below. It works for any year range, in O(n log n).
 */
class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[2051];
        for (int[] log : logs) {
            diff[log[0]]++;
            diff[log[1]]--;
        }

        int maxPopulation = 0;
        int population = 0;
        int bestYear = 1950;
        for (int year = 1950; year <= 2050; year++) {
            population += diff[year];
            if (population > maxPopulation) {
                maxPopulation = population;
                bestYear = year;
            }
        }
        return bestYear;
    }

    // Alternative: sort births and deaths as events and sweep through them.
    public int maximumPopulationSweep(int[][] logs) {
        List<int[]> events = new ArrayList<>();
        for (int[] log : logs) {
            events.add(new int[] {log[0], +1});
            events.add(new int[] {log[1], -1});
        }
        // Same year: process deaths (-1) before births (+1).
        events.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int maxPopulation = 0;
        int population = 0;
        int bestYear = 1950;
        for (int[] event : events) {
            population += event[1];
            if (population > maxPopulation) {
                maxPopulation = population;
                bestYear = event[0];
            }
        }
        return bestYear;
    }
}
