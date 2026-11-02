class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        VersionControl.firstBad = 4;
        Assert.equal(4, s.firstBadVersion(5));
        VersionControl.firstBad = 1;
        Assert.equal(1, s.firstBadVersion(1));
        VersionControl.firstBad = 1702766719;
        Assert.equal(1702766719, s.firstBadVersion(2126753390));
    }
}
