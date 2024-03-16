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
        
        if(head == null || head.next == null)
            return head;
        Set<Integer> set = new HashSet<>();
        Set<Integer> dupSet = new HashSet<>();
        
        ListNode temp = head;
        while(temp != null){
            if(set.contains(temp.val))
                dupSet.add(temp.val);
            else
                set.add(temp.val);
            temp = temp.next;
        }
       
        ListNode zeroNode = new ListNode(-101, head);
        temp = head;
        ListNode prev = zeroNode;
        while(temp != null){
            if(dupSet.contains(temp.val)){
                prev.next = temp.next;
                temp = temp.next;
            }
            else{
                prev = temp;
                temp = temp.next;
            }
        }
        return zeroNode.next;
       
    }
}