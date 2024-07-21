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
        
        Map<Node, Node> oldToNew = new HashMap<>();
        
        for (var pointer = head; pointer != null; pointer = pointer.next) {
            oldToNew.put(pointer, new Node(pointer.val));
        }
        
        for (var pointer = head; pointer != null; pointer = pointer.next) {
            oldToNew.get(pointer).next = oldToNew.get(pointer.next);
            oldToNew.get(pointer).random = oldToNew.get(pointer.random);
        }
        
        return oldToNew.get(head);
    }
}