/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        var dummy = new ListNode();
        var pointer = dummy;
        var carry = 0;

        while (l1 != null || l2 != null) {

            var x = l1 != null ? l1.val : 0;
            var y = l2 != null ? l2.val : 0;
            var sum = x + y + carry;

            carry = sum / 10;

            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }

        return dummy.next;
    }
}