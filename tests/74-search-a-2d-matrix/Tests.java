class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        Assert.isTrue(s.searchMatrix(matrix, 3));
        Assert.isTrue(s.searchMatrix(matrix, 60));
        Assert.isFalse(s.searchMatrix(matrix, 13));
        Assert.isFalse(s.searchMatrix(new int[][] {{1}}, 2));
    }
}
