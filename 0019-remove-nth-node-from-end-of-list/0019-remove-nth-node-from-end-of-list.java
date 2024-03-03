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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast=head, slow=head, prev=dummy;
        for(int i=0; i<n; i++)
            fast = fast.next;
        
        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        prev.next = slow.next;
        slow.next = null;
        return dummy.next;
        
    }
}