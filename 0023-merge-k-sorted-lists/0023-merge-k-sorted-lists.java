class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        var dummy = new ListNode(-1);
        var prev = dummy;

        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (var l : lists) {
            if (l != null) {
                minHeap.offer(l);
            }
        }

        while (minHeap.size() > 0) {

            var current = minHeap.poll();
            
            prev.next = current;
            prev = prev.next;

            if (current.next != null) {
                minHeap.offer(current.next);
            }
        }

        return dummy.next;
    }
}