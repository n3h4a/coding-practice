class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal("ace", s.shiftingLetters("abc", new int[][] {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}}));
        Assert.equal("catz", s.shiftingLetters("dztz", new int[][] {{0, 0, 0}, {1, 1, 1}}));
        Assert.equal("z", s.shiftingLetters("a", new int[][] {{0, 0, 0}}));
    }
}
