package com.flameshine.nebula.problems.leetcode.learn.linked_list;

import java.util.Objects;

/**
 * №160 Intersection of Two Linked Lists
 *
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String... args) {

        var headA4 = new ListNode(5);
        var headA3 = new ListNode(4, headA4);
        var headA2 = new ListNode(8, headA3);
        var headA1 = new ListNode(1, headA2);
        var headA = new ListNode(4, headA1);

        var headB5 = new ListNode(5);
        var headB4 = new ListNode(4, headB5);
        var headB3 = new ListNode(8, headB4);
        var headB2 = new ListNode(1, headB3);
        var headB1 = new ListNode(6, headB2);
        var headB = new ListNode(5, headB1);

        System.out.println(
            getIntersectionNode(headA, headB)
        );
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        var aPointer = headA;
        var bPointer = headB;

        while (aPointer != bPointer) {
            aPointer = aPointer == null ? headB : aPointer.next;
            bPointer = bPointer == null ? headA : bPointer.next;
        }

        return aPointer;
    }

    static class ListNode {

        private final int val;
        private final ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }

            if (!(o instanceof ListNode that)) {
                return false;
            }

            return val == that.val && Objects.equals(next, that.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}