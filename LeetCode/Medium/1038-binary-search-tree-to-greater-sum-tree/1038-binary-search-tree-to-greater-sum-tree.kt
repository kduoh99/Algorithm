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
    var value = 0

    fun bstToGst(root: TreeNode?): TreeNode? {
        if (root == null) return null

        bstToGst(root.right)
        value += root.`val`
        root.`val` = value
        bstToGst(root.left)

        return root
    }
}