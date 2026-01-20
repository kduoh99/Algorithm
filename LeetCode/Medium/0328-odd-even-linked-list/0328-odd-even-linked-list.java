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
    public ListNode oddEvenList(ListNode head) {
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();
        int count = 0;

        while (head != null) {
            if (count % 2 == 0) {
                d1.offer(head.val);
            } else {
                d2.offer(head.val);
            }
            count++;
            head = head.next;
        }

        ListNode node = new ListNode();
        ListNode curr = node;

        while (!d1.isEmpty()) {
            curr.next = new ListNode(d1.poll());
            curr = curr.next;
        }

        while (!d2.isEmpty()) {
            curr.next = new ListNode(d2.poll());
            curr = curr.next;
        }

        return node.next;
    }
}