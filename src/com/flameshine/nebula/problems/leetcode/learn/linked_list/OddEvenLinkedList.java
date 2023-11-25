package com.flameshine.nebula.problems.leetcode.learn.linked_list;

import java.util.Objects;

/**
 * №328 Odd Even Linked List
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */
public class OddEvenLinkedList {

    public static void main(String... args) {

        var fifth = new ListNode(5);
        var fourth = new ListNode(4, fifth);
        var third = new ListNode(3, fourth);
        var second = new ListNode(2, third);
        var head = new ListNode(1, second);

        System.out.println(
            oddEvenList(head)
        );
    }

    private static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
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