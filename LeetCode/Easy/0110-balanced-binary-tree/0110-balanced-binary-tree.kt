/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val left = dfs(node.left)
            if (left == -1) return -1

            val right = dfs(node.right)
            if (right == -1) return -1

            if (abs(left - right) > 1) return -1

            return maxOf(left, right) + 1
        }

        return dfs(root) != -1
    }
}