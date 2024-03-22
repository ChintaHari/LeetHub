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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        ListNode curr = head;
        
        ListNode copyHead = copyList(head);

        ListNode reverse = reverseList(copyHead);
        curr = head;
        
        while(curr != null && reverse != null){
            if(curr.val != reverse.val)
                return false;
            curr = curr.next;
            reverse = reverse.next;
        }
        
        return true;
        
        
//         Stack<Integer> stack = new Stack<>();
//         ListNode temp = head;
//         while(temp != null){
//             stack.push(temp.val);
//             temp = temp.next;
//         }
        
//         while(head != null){
//             if(head.val != stack.pop())
//                 return false;
//             head = head.next;
//         }
//         return true;
    }
    
    public ListNode reverseList(ListNode node){
        ListNode prev = null;
        while(node != null){
            ListNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }
        return prev;
    }
    
    private ListNode copyList(ListNode node) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(node != null) {
            tail.next = new ListNode(node.val);
            tail = tail.next;
            node = node.next;
        }
        return dummy.next;
    }
}