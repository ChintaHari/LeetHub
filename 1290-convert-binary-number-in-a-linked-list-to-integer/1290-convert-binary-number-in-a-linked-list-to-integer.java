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
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        temp = head;
        int number = 0;
        for(int i=n-1; i>=0 && temp!=null; i--){
            number = number + (int)(temp.val * Math.pow(2, i));
            temp = temp.next;
        }
        
        return number;
        
    }
}