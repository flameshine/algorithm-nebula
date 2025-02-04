class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null;

        for (var l : lists) {
            result = merge(result, l);
        }

        return result;
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        var dummy = new ListNode(0);
        var pointer = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }

            pointer = pointer.next;
        }

        pointer.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}