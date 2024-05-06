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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        
        while(current != null){
            stack.push(current);
            current = current.next;
        }
        
        ListNode finalList = stack.pop();
        int currentMaximum = finalList.val;
        
        while(!stack.isEmpty()){
            current = stack.pop();
            if(current.val < currentMaximum)
                continue;
            else{
                ListNode newNode = new ListNode(current.val);
                newNode.next = finalList;
                finalList = newNode;
                currentMaximum = finalList.val;
            }
        }
        return finalList;
    }
}