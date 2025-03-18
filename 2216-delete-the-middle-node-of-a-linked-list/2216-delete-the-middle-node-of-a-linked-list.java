class Solution {

    public ListNode deleteMiddle(ListNode head) {

        if (head == null) {
            return null;
        }

        var prev = new ListNode(0);

        prev.next = head;

        var fast = head;
        var slow = prev;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return prev.next;
    }
}