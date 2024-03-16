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
        
        if(head == null || head.next == null)
            return null;
        
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            count ++;
        }
        
        if(count == n)
            return head.next;
        
        ListNode slow = head, fast = head;
        for(int i=0; i<n; i++)
            fast = fast.next;
        
        ListNode prev = head;
        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        prev.next = slow.next;
        return head;
        
    }
}