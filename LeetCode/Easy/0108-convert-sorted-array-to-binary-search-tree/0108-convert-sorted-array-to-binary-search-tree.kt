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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        fun construct(low: Int, high: Int): TreeNode? {
            if (low > high) return null

            val mid = (low + high) / 2
            
            val node = TreeNode(nums[mid])
            node.left = construct(low, mid - 1)
            node.right = construct(mid + 1, high)
            
            return node
        }

        return construct(0, nums.size - 1)
    }
}