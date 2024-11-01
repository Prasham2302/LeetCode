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
    public ListNode mergeNodes(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        int sum = 0;
        ListNode newHead = null;
        while (curr != null) {
            sum += curr.val;
            if (curr.val == 0 && prev == null) {
                prev = curr;
            }
            else if (curr.val == 0) {
                ListNode newNode = new ListNode(sum, curr.next);
                if (prev.val != 0)
                    prev.next = newNode;
                prev = newNode;
                if (newHead == null) {
                    newHead = newNode;
                }
                sum = 0;
            }
            curr = curr.next;
        }
        return newHead;
    }
}