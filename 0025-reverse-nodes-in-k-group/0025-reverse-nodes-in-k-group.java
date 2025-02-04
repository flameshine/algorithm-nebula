class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null || k == 1) {
            return head;
        }

        var dummy = new ListNode(0);

        dummy.next = head;

        var pointer = head;
        var previous = dummy;
        var count = 0;

        while (pointer != null) {
            ++count;
            pointer = pointer.next;
        }

        while (count >= k) {

            pointer = previous.next;

            var next = pointer.next;

            for (var i = 1; i < k; i++) {
                pointer.next = next.next;
                next.next = previous.next;
                previous.next = next;
                next = pointer.next;
            }

            previous = pointer;
            count -= k;
        }

        return dummy.next;
    }
}