class Solution {
    
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null || head.next == null) {
            return null;
        }

        var odd = head;
        var even = head.next;
        var evenHead = even;

        while (even != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}