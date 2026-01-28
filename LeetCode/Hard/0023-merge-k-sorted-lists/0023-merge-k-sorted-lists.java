/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode l : lists) {
            if (l != null) {
                pq.offer(l);
            }
        }

        ListNode node = new ListNode();
        ListNode curr = node;

        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return node.next;
    }
}