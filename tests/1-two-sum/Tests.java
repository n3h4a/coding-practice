class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.equal(new int[] {0, 1}, s.twoSum(new int[] {2, 7, 11, 15}, 9));
        Assert.equal(new int[] {1, 2}, s.twoSum(new int[] {3, 2, 4}, 6));
        Assert.equal(new int[] {0, 1}, s.twoSum(new int[] {3, 3}, 6));
    }
}
