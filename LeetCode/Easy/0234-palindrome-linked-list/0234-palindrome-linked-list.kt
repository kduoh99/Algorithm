/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        val dq = ArrayDeque<Int>()

        var node = head
        while (node != null) {
            dq.addLast(node.`val`)
            node = node.next
        }

        while (dq.size > 1) {
            if (dq.removeFirst() != dq.removeLast()) {
                return false;
            }
        }

        return true;
    }
}