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
    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode fast = head, slow = head, prev = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = reverse(slow);
        int maxSum = 0;
        fast = head;
        slow = prev.next;
        while(slow != null) {
            maxSum = Math.max(fast.val + slow.val, maxSum);
            fast=fast.next;
            slow=slow.next;
        }
        return maxSum;
    }
}