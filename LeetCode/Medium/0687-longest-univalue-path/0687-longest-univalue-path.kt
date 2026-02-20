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
    fun longestUnivaluePath(root: TreeNode?): Int {
        var longest = 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            var left = dfs(node.left)
            var right = dfs(node.right)

            left = if (node.left?.`val` == node.`val`) left + 1 else 0
            right = if (node.right?.`val` == node.`val`) right + 1 else 0

            longest = maxOf(longest, left + right)
            return maxOf(left, right)
        }

        dfs(root)
        return longest
    }
}