class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(3, s.firstMissingPositive(new int[] {1, 2, 0}));
        Assert.equal(2, s.firstMissingPositive(new int[] {3, 4, -1, 1}));
        Assert.equal(1, s.firstMissingPositive(new int[] {7, 8, 9, 11, 12}));
        Assert.equal(2, s.firstMissingPositive(new int[] {1, 1}));
        Assert.equal(4, s.firstMissingPositive(new int[] {1, 2, 3}));
    }
}
