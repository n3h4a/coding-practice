class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5),
                s.spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Assert.equal(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                s.spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        Assert.equal(List.of(1, 2, 3), s.spiralOrder(new int[][] {{1}, {2}, {3}}));
    }
}
