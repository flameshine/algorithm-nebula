class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        var result = lists[0];

        for (var i = 1; i < lists.length; i++) {
            result = merge(result, lists[i]);
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