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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode();
        ListNode curr = node;
        int k = left;

        while (k > 1) {
            curr.next = new ListNode(head.val);
            curr = curr.next;
            head = head.next;
            k--;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        
        while (head != null && left <= right) {
            dq.offer(head.val);
            head = head.next;
            left++;
        }

        while (!dq.isEmpty()) {
            curr.next = new ListNode(dq.pollLast());
            curr = curr.next;
        }

        while (head != null) {
            curr.next = new ListNode(head.val);
            curr = curr.next;
            head = head.next;
        }

        return node.next;
    }
}