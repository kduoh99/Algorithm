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
    private int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        TreeNode node = new TreeNode(preorder[preIdx++]);

        int inIdx = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                inIdx = i;
                break;
            }
        }

        node.left = dfs(preorder, inorder, inStart, inIdx - 1);
        node.right = dfs(preorder, inorder, inIdx + 1, inEnd);

        return node;
    }
}