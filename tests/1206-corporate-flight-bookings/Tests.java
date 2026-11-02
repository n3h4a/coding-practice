class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(new int[] {10, 55, 45, 25, 25},
                s.corpFlightBookings(new int[][] {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5));
        Assert.equal(new int[] {10, 25}, s.corpFlightBookings(new int[][] {{1, 2, 10}, {2, 2, 15}}, 2));
    }
}
