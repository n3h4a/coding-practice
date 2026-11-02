/*
 * Corporate Flight Bookings
 * Pattern : Difference Array / Prefix Sum
 * Approach: A booking [first, last, seats] adds `seats` at first and
 *           subtracts it after last in a difference array. One prefix-sum
 *           pass then gives the total seats on every flight.
 * Time    : O(n + bookings)
 * Space   : O(n)
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];

        for (int[] booking : bookings) {
            int start = booking[0] - 1; // flights are 1-indexed
            int end = booking[1] - 1;
            int seats = booking[2];

            diff[start] += seats;
            diff[end + 1] -= seats;
        }

        int[] answer = new int[n];
        int running = 0;
        for (int i = 0; i < n; i++) {
            running += diff[i];
            answer[i] = running;
        }
        return answer;
    }
}
