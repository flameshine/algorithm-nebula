class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {

        if (start == end) {
            return lists[start];
        }

        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }

        var middle = start + (end - start) / 2;
        var left = merge(lists, start, middle);
        var right = merge(lists, middle + 1, end);

        return merge(left, right);
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