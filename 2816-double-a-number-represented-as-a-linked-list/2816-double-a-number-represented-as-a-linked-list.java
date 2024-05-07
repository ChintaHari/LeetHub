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
    public ListNode doubleIt(ListNode head) {
        if (head == null)
            return null;

        head = reverseList(head);

        ListNode current = head;
        int carry = 0;
        while (current != null) {
            int doubledValue = (current.val * 2) + carry;
            current.val = doubledValue % 10;
            carry = doubledValue / 10;
            if (current.next == null && carry > 0) {
                current.next = new ListNode(carry);
                break;
            }
            current = current.next;
        }

        return reverseList(head);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
