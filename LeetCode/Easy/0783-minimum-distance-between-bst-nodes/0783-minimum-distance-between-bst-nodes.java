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
    private int minDiff = 100001;
    private int prev = -100001;

    public int minDiffInBST(TreeNode root) {
        if (root == null) return minDiff;

        minDiffInBST(root.left);

        minDiff = Math.min(minDiff, root.val - prev);
        prev = root.val;

        minDiffInBST(root.right);

        return minDiff;
    }
}