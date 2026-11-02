class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(4, s.numIdenticalPairs(new int[] {1, 2, 3, 1, 1, 3}));
        Assert.equal(6, s.numIdenticalPairs(new int[] {1, 1, 1, 1}));
        Assert.equal(0, s.numIdenticalPairs(new int[] {1, 2, 3}));
    }
}
