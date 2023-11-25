package com.flameshine.nebula.problems.leetcode.learn.linked_list;

import java.util.Objects;

/**
 * №19 Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String... args) {

        var third = new ListNode(3);
        var second = new ListNode(2, third);
        var head = new ListNode(1, second);

        System.out.println(
            removeNthFromEnd(head, 3)
        );
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {

        var length = 0;

        for (var pointer = head; pointer != null; pointer = pointer.next) {
            ++length;
        }

        if (length == 1) {
            return null;
        }

        if (length == n) {
            return head.next;
        }

        var counter = 0;
        var pointer = head;

        while (pointer != null) {
            if (counter++ == length - n - 1) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }

        return head;
    }

    static class ListNode {

        private final int val;

        private ListNode next;

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