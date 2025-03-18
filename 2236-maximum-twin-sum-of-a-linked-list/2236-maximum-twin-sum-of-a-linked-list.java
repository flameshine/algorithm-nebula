class Solution {

    public int pairSum(ListNode head) {
        
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;

        while (slow != null) {
            var next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        var result = 0;

        while (prev != null) {
            result = Math.max(result, head.val + prev.val);
            prev = prev.next;
            head = head.next;
        }

        return result;
    }
}