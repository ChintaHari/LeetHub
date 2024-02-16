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
        
       ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        for(int i=1; i<left; i++)
            prev = prev.next;
        
        ListNode curr = prev.next;
        ListNode nextNode = null;
        for(int i=left; i<=right && curr!=null; i++){
            ListNode nextNodetemp = curr.next;
            curr.next = nextNode;
            nextNode = curr;
            curr = nextNodetemp;
        }
        
        prev.next.next = curr;
        prev.next = nextNode;
        
        return dummy.next;
    }
}