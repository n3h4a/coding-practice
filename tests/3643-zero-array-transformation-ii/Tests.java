class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(2, s.minZeroArray(new int[] {2, 0, 2}, new int[][] {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}}));
        Assert.equal(-1, s.minZeroArray(new int[] {4, 3, 2, 1}, new int[][] {{1, 3, 2}, {0, 2, 1}}));
        Assert.equal(0, s.minZeroArray(new int[] {0, 0}, new int[][] {{0, 1, 1}}));
    }
}
