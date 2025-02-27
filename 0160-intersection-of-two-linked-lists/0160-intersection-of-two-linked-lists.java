public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        var aPointer = headA;
        var bPointer = headB;

        while (aPointer != bPointer) {

            if (aPointer == null) {
                aPointer = headB;
            } else {
                aPointer = aPointer.next;
            }

            if (bPointer == null) {
                bPointer = headA;
            } else {
                bPointer = bPointer.next;
            }
        }

        return aPointer;
    }
}