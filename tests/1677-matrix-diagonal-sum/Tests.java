class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(25, s.diagonalSum(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Assert.equal(8, s.diagonalSum(new int[][] {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}));
        Assert.equal(5, s.diagonalSum(new int[][] {{5}}));
    }
}
