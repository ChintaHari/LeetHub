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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        while(curr != null && curr.next != null){
            ListNode newNode = new ListNode(calculateGCD(curr.val, curr.next.val));
            ListNode tempNode = curr.next;
            curr.next = newNode;
            newNode.next = tempNode;
            curr = curr.next.next;
        }
        return dummy.next;
        
    }
    
    public int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}