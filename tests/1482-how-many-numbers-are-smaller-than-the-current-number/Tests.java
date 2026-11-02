class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(new int[] {4, 0, 1, 1, 3}, s.smallerNumbersThanCurrent(new int[] {8, 1, 2, 2, 3}));
        Assert.equal(new int[] {2, 1, 0, 3}, s.smallerNumbersThanCurrent(new int[] {6, 5, 4, 8}));
        Assert.equal(new int[] {0, 0, 0}, s.smallerNumbersThanCurrent(new int[] {7, 7, 7}));
        Assert.equal(new int[] {1, 0}, s.smallerNumbersThanCurrent(new int[] {100, 0}));
    }
}
