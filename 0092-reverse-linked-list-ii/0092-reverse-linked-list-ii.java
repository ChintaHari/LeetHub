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
        
        if(head == null || head.next == null)
            return head;
        
        ListNode zeroNode = new ListNode(-501, head);
        ListNode leftPointer = zeroNode;
        for(int i=1; i<left; i++)
            leftPointer = leftPointer.next;
        
        ListNode current = leftPointer.next;
        ListNode prev = null;
        for(int i=left; i<=right && current!=null; i++){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        
        leftPointer.next.next = current;
        leftPointer.next = prev;
        
        return zeroNode.next;
        
    }
}