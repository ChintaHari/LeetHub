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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        if(head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};
        
        ListNode prev = head;
        ListNode curr = head.next;
        int currentNodeIndex = 2;
        
        List<Integer> criticalPoints = new ArrayList<>();
        
        while(curr.next != null){
            if((curr.val > prev.val) && (curr.val > curr.next.val) 
               ||
               (curr.val < prev.val) && (curr.val < curr.next.val)){
                    criticalPoints.add(currentNodeIndex);
            }
            
            currentNodeIndex++;
            prev = curr;
            curr = curr.next;
        }
        
        int[] critical = criticalPoints.stream().mapToInt(Integer :: intValue).toArray();
        
        if(critical.length < 2)
            return new int[]{-1, -1};
        
        else if(critical.length == 2)
            return new int[]{critical[1] - critical[0], critical[1] - critical[0]};
        
        else{
            int maxDistance = critical[critical.length - 1] - critical[0];
            int minDistance = Integer.MAX_VALUE;
            for(int i=1; i < critical.length; i++)
                minDistance = Math.min(minDistance, critical[i] - critical[i-1]);
            return new int[]{minDistance, maxDistance};
                
        }
        
    }
}