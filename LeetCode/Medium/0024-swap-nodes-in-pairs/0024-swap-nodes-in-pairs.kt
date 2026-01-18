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
    fun swapPairs(head: ListNode?): ListNode? {
        val node = ListNode(0)
        var curr = node
        var h = head

        while (h != null) {
            if (h.next != null) {
                curr.next = ListNode(h.next.`val`)
                curr.next.next = ListNode(h.`val`)
                curr = curr.next.next
                h = h.next.next
            } else {
                curr.next = ListNode(h.`val`)
                curr = curr.next
                h = h.next
            }
        }

        return node.next
    }
}