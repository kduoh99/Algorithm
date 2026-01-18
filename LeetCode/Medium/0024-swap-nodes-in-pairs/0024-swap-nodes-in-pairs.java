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
            boolean flag = false;
            int a = head.val;
            int b = 0;
            head = head.next;

            if (head != null) {
                b = head.val;
                head = head.next;
                flag = true;
            }

            if (flag) {
                curr.next = new ListNode(b);
                curr = curr.next;
                curr.next = new ListNode(a);
                curr = curr.next;
            } else {
                curr.next = new ListNode(a);
                curr = curr.next;
            }
        }

        return node.next;
    }
}