class Solution {

    public Node copyRandomList(Node head) {
        
        if (head == null) {
            return null;
        }

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