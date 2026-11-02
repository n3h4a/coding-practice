class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(2, s.findDuplicate(new int[] {1, 3, 4, 2, 2}));
        Assert.equal(3, s.findDuplicate(new int[] {3, 1, 3, 4, 2}));
        Assert.equal(3, s.findDuplicate(new int[] {3, 3, 3, 3, 3}));
    }
}
