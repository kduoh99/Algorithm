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
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val node = ListNode(0)
        var curr = node
        var h = head
        var k = 1

        while (h != null && k < left) {
            curr.next = ListNode(h.`val`)
            curr = curr.next
            h = h.next
            k++
        }

        val dq = ArrayDeque<Int>()
        
        while (h != null && k <= right) {
            dq.addLast(h.`val`)
            h = h.next
            k++
        }

        while (dq.isNotEmpty()) {
            curr.next = ListNode(dq.removeLast())
            curr = curr.next
        }

        while (h != null) {
            curr.next = ListNode(h.`val`)
            curr = curr.next
            h = h.next
        }

        return node.next
    }
}