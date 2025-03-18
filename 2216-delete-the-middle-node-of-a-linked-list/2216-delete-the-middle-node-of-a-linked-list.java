class Solution {

    public ListNode deleteMiddle(ListNode head) {

        if (head.next == null) {
            return null;
        }
        
        var fast = head;
        var prevSlow = head;
        var slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        if (fast.next == null) {
            prevSlow.next = slow.next;
        } else {
            slow.next = slow.next.next;
        }

        return head;
    }
}