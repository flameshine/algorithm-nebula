package com.flameshine.nebula.problems.leetcode.learn.linked_list;

import java.util.Objects;

/**
 * №21 Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {

    public static void main(String... args) {

        var third1 = new ListNode(4);
        var second1 = new ListNode(2, third1);
        var head1 = new ListNode(1, second1);
        var third2 = new ListNode(4);
        var second2 = new ListNode(3, third2);
        var head2 = new ListNode(1, second2);

        System.out.println(
            mergeTwoLists(head1, head2)
        );
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        var head = new ListNode();
        var pointer = head;
        var pointer1 = list1;
        var pointer2 = list2;

        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val < pointer2.val) {
                pointer.next = pointer1;
                pointer = pointer1;
                pointer1 = pointer1.next;
            } else {
                pointer.next = pointer2;
                pointer = pointer2;
                pointer2 = pointer2.next;
            }
        }

        while (pointer1 != null) {
            pointer.next = pointer1;
            pointer = pointer1;
            pointer1 = pointer1.next;
        }

        while (pointer2 != null) {
            pointer.next = pointer2;
            pointer = pointer2;
            pointer2 = pointer2.next;
        }

        return head.next;
    }

    static class ListNode {

        private int val;
        private ListNode next;

        public ListNode() { }

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