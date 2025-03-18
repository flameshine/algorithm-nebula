class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode result = null;

        while (head != null) {

            if (result == null) {
                result = new ListNode(head.val);
            } else {
                result = new ListNode(head.val, result);
            }

            head = head.next;
        }

        return result;
    }
}