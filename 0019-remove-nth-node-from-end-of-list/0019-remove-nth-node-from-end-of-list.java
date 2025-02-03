class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        var fast = head;

        for (var i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        var slow = head;
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}