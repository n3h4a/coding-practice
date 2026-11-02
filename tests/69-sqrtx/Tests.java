class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(0, s.mySqrt(0));
        Assert.equal(1, s.mySqrt(1));
        Assert.equal(2, s.mySqrt(8));
        Assert.equal(3, s.mySqrt(9));
        Assert.equal(46340, s.mySqrt(Integer.MAX_VALUE));
    }
}
