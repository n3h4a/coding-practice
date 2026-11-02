/*
 * Count Nodes Equal to Average of Subtree
 * Pattern : Tree DFS (Post-order)
 * Approach: A post-order traversal returns (sum, nodeCount) for each
 *           subtree, so every node gets its subtree totals from its
 *           children in O(1) and compares the rounded-down average with
 *           its own value.
 * Time    : O(n)
 * Space   : O(h) recursion stack, h = tree height
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int matches = 0;

    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return matches;
    }

    // Returns {sum, nodeCount} of the subtree rooted at node.
    private int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;
        if (sum / count == node.val) {
            matches++;
        }
        return new int[] {sum, count};
    }
}
