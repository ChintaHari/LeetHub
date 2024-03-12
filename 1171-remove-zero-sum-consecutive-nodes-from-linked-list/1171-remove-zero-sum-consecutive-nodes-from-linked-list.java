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
// class Solution {
//     public ListNode removeZeroSumSublists(ListNode head) {
        
//         ListNode dummy = new ListNode(0, head);
//         ListNode start = dummy;
//         while(start != null){
//             int prefixSum = 0;
//             ListNode end = start.next;
//             while(end != null){
//                 prefixSum = prefixSum + end.val;
//                 if(prefixSum == 0)
//                     start.next = end.next;
//                 end = end.next;
//             }
//             start = start.next;
//         }
//         return dummy.next;
//     }
// }


class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;
        Map<Integer, ListNode> hm = new HashMap<>();
        hm.put(0, dummy);
        
        int prefixSum = 0;
        while(current != null){
            prefixSum = prefixSum + current.val;
            hm.put(prefixSum, current);
            current = current.next;
        }
        
        prefixSum = 0;
        current = dummy;
        
        while(current != null){
            prefixSum = prefixSum + current.val;
            current.next = hm.get(prefixSum).next;
            current = current.next;
        }
        
        return dummy.next;
       
    }
}

