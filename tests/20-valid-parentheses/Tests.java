class Tests {
    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.isTrue(s.isValid("()[]{}"));
        Assert.isTrue(s.isValid("{[()]}"));
        Assert.isFalse(s.isValid("(]"));
        Assert.isFalse(s.isValid("(("));
        Assert.isFalse(s.isValid("]"));
    }
}
