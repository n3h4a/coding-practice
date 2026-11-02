class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.isTrue(s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 0));
        Assert.isFalse(s.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 3));
        Assert.isTrue(s.search(new int[] {1, 0, 1, 1, 1}, 0));
        Assert.isTrue(s.search(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 13));
    }
}
