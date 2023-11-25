package com.flameshine.nebula.problems.leetcode.learn.linked_list;

import java.util.Objects;

/**
 * №206 Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    public static void main(String... args) {

        var third = new ListNode(3);
        var second = new ListNode(2, third);
        var head = new ListNode(1, second);

        System.out.println(
            reverseList(head)
        );
    }

    private static ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
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