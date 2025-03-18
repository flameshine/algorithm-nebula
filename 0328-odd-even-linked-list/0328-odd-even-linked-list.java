class Solution {
    
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null) {
            return null;
        }

        var odd = head;
        var even = head.next;
        var evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}