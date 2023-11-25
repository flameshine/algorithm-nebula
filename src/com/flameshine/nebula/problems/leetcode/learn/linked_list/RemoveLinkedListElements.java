package com.flameshine.nebula.problems.leetcode.learn.linked_list;

import java.util.Objects;

/**
 * №203 Remove Linked List Elements
 *
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */
public class RemoveLinkedListElements {

    public static void main(String... args) {

        var fifth = new ListNode(3);
        var fourth = new ListNode(4, fifth);
        var third = new ListNode(3, fourth);
        var second = new ListNode(2, third);
        var head = new ListNode(1, second);

        System.out.println(
            removeElements(head, 3)
        );
    }

    private static ListNode removeElements(ListNode head, int val) {

        var dummy = new ListNode(0);

        dummy.next = head;

        var current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
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