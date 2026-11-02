class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(19, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5}, new int[][] {{1, 3}, {0, 1}}));
        Assert.equal(11, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5, 6}, new int[][] {{0, 1}}));
        Assert.equal(47, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5, 10}, new int[][] {{0, 2}, {1, 3}, {1, 1}}));
    }
}
