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
        
        int length = 0;
        ListNode dummy = head;
        while(dummy != null){
            length ++;
            dummy = dummy.next;
        }
        int nodeToBeDeleted = length - n;
        ListNode prev = null;
        ListNode curr = head;
        
        if(nodeToBeDeleted == 0)
            return head.next;
        
        for(int i=0; i<nodeToBeDeleted; i++){
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = curr.next;
        curr.next = null;
        
        return head;
        
    }
}