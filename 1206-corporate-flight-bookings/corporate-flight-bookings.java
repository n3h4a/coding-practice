class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] diff = new int[n + 1];

        // Create difference array
        for (int[] booking : bookings) {

            int start = booking[0] - 1; // convert to 0-index
            int end = booking[1] - 1;
            int seats = booking[2];

            diff[start] += seats;

            if (end + 1 < n) {
                diff[end + 1] -= seats;
            }
        }

        // Prefix sum to get actual seats
        int[] answer = new int[n];

        answer[0] = diff[0];

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + diff[i];
        }

        return answer;
    }
}