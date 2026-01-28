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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode>(compareBy { it.`val` })

        for (l in lists) {
            if (l != null) {
                pq.offer(l)
            }
        }

        val node = ListNode()
        var curr = node

        while (pq.isNotEmpty()) {
            curr.next = pq.poll()
            curr = curr.next

            if (curr.next != null) {
                pq.offer(curr.next)
            }
        }

        return node.next
    }
}