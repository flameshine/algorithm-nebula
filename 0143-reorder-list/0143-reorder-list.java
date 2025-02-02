class Solution {

    public void reorderList(ListNode head) {
        
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var second = slow.next;

        slow.next = null;

        ListNode previous = null;

        while (second != null) {
            var temp = second.next;
            second.next = previous;
            previous = second;
            second = temp;
        }

        var first = head;

        while (previous != null) {
            var tmp1 = first.next;
            var tmp2 = previous.next;
            first.next = previous;
            previous.next = tmp1;
            first = tmp1;
            previous = tmp2;
        }
    }
}