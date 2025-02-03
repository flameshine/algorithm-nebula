class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        var dummy = new ListNode();
        var pointer = dummy;
        var carry = 0;

        while (l1 != null || l2 != null) {

            var x = l1 == null ? 0 : l1.val;
            var y = l2 == null ? 0 : l2.val;
            var sum = x + y + carry;

            carry = sum / 10;

            pointer.next = new ListNode(sum % 10);

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            pointer = pointer.next;
        }

        if (carry != 0) {
            pointer.next = new ListNode(carry);
        } 

        return dummy.next;
    }
}