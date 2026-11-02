class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(new int[] {102, 120, 130, 132, 210, 230, 302, 310, 312, 320},
                s.findEvenNumbers(new int[] {2, 1, 3, 0}));
        Assert.equal(new int[] {222, 228, 282, 288, 822, 828, 882},
                s.findEvenNumbers(new int[] {2, 2, 8, 8, 2}));
        Assert.equal(new int[] {}, s.findEvenNumbers(new int[] {3, 7, 5}));
    }
}
