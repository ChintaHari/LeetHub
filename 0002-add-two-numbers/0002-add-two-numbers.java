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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int result = 0, carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while(l1 != null || l2 != null){
            int node1Value = l1 == null ? 0 : l1.val;
            int node2Value = l2 == null ? 0 : l2.val;
            
            int sum = node1Value + node2Value + carry;
            carry = sum/10;
            
            int digit = sum % 10;
            
            ListNode newNode = new ListNode(digit);
            current.next = newNode;
            current = current.next;
            
            if(l1 != null)
                l1 = l1.next;
            
            if(l2 != null)
                l2 = l2.next;
        }
        
        if (carry > 0) {
            ListNode carryNode = new ListNode(carry);
            current.next = carryNode;
        }
        
        return dummy.next;
        
    }
}