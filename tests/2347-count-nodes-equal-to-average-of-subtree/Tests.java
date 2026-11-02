class Tests {
    public static void main(String[] args) {
        // [4,8,5,0,1,null,6]
        TreeNode root = new TreeNode(4,
                new TreeNode(8, new TreeNode(0), new TreeNode(1)),
                new TreeNode(5, null, new TreeNode(6)));
        Assert.equal(5, new Solution().averageOfSubtree(root));
        Assert.equal(1, new Solution().averageOfSubtree(new TreeNode(1)));
    }
}
