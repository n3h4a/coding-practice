class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(2, s.missingNumber(new int[] {3, 0, 1}));
        Assert.equal(2, s.missingNumber(new int[] {0, 1}));
        Assert.equal(8, s.missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
        Assert.equal(0, s.missingNumber(new int[] {1}));
    }
}
