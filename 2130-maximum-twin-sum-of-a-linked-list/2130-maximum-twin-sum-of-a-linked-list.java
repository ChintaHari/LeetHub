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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        int maxSum = Integer.MIN_VALUE;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode firstHalf = head;
        ListNode secondHalf = reverse(slow);
        while(secondHalf != null){
            int currSum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(maxSum, currSum);
            
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return maxSum;
        
    }
    
    public ListNode reverse(ListNode slow){
        ListNode prev = null;
        while(slow != null){
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        return prev;
    }
}