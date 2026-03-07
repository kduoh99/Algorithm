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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while (head != null) {
            while (prev.next != null && prev.next.val < head.val)
                prev = prev.next;

            ListNode next = head.next;
            head.next = prev.next;
            prev.next = head;
            
            head = next;
            prev = dummy;
        }

        return dummy.next;
    }
}