class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        var dummy = new ListNode(0, head);
        var previous = dummy;

        for (var i = 0; i < left - 1; i++) {
            previous = previous.next;
        }

        var current = previous.next;

        for (var i = 0; i < right - left; i++) {
            var next = current.next;
            current.next = next.next;
            next.next = previous.next;
            previous.next = next;
        }

        return dummy.next;
    }
}