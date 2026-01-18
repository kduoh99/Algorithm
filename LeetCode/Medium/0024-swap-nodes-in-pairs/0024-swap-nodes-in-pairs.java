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
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode();
        ListNode curr = node;

        while (head != null) {
            if (head.next != null) {
                curr.next = new ListNode(head.next.val);
                curr.next.next = new ListNode(head.val);
                curr = curr.next.next;
                head = head.next.next;
            } else {
                curr.next = new ListNode(head.val);
                curr = curr.next;
                head = head.next;
            }
        }

        return node.next;
    }
}