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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode zeroNode = new ListNode(-101, head);
        ListNode curr = head, prev = zeroNode;
        while(curr!=null){
            if(curr.val == prev.val)
                prev.next = curr.next;
            else
                prev = curr;
            curr = curr.next;
        }
           
        return head;
    }
}