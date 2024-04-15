/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null){
            Node copy = map.get(curr);
            copy.next = map.getOrDefault(curr.next, null);
            copy.random = map.getOrDefault(curr.random, null);
            curr = curr.next;
        }
        
        return map.get(head);
    }
}