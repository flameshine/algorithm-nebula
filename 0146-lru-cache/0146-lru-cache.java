class LRUCache {

    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;
    private final int capacity;

    public LRUCache(int capacity) {

        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if (!map.containsKey(key)) {
            return -1;
        }

        var node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (map.size() == capacity) {
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private static class Node {

        private Node next;
        private Node prev;
        private int key;
        private int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}