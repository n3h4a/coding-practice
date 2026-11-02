class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(new int[][] {{1, 2, 3, 4}}, s.matrixReshape(new int[][] {{1, 2}, {3, 4}}, 1, 4));
        Assert.equal(new int[][] {{1, 2}, {3, 4}}, s.matrixReshape(new int[][] {{1, 2}, {3, 4}}, 2, 4));
        Assert.equal(new int[][] {{1, 2}, {3, 4}, {5, 6}}, s.matrixReshape(new int[][] {{1, 2, 3}, {4, 5, 6}}, 3, 2));
    }
}
