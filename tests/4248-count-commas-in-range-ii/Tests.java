class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(0L, s.countCommas(998));
        Assert.equal(3L, s.countCommas(1002));
        Assert.equal(999_002L, s.countCommas(1_000_000));
    }
}
