class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(2, s.maxFrequency(new int[] {1, 4, 5}, 1, 2));
        Assert.equal(2, s.maxFrequency(new int[] {5, 11, 20, 20}, 5, 1));
        Assert.equal(2, s.maxFrequency(new int[] {1_000_000_000, 999_999_999, 1}, 1, 3)); // large values
    }
}
