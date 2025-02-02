class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }

            current = current.next;
        }

        current.next = list1 == null ? list2 : list1;

        return dummy.next;
    }
}