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
    public int getDecimalValue(ListNode head) {
        int size = 0;
        ListNode curr = head;
        int decimalValue = 0;
        
        while(curr != null){
            size++;
            curr = curr.next;
        }
        
        curr = head;
        for(int i = size - 1; i >= 0; i--){
            decimalValue = decimalValue + (int)(curr.val * Math.pow(2, i));
            curr = curr.next;
        }
        return decimalValue;
    }
}