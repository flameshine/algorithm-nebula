package com.flameshine.nebula.problems.leetcode.learn.linked_list;

import java.util.Objects;

/**
 * №61 Rotate List
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 */
public class RotateList {

    public static void main(String... args) {

        var fifth = new ListNode(5);
        var fourth = new ListNode(4, fifth);
        var third = new ListNode(3, fourth);
        var second = new ListNode(2, third);
        var head = new ListNode(1, second);

        System.out.println(
            rotateRight(head, 2)
        );
    }

    private static ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        var tail = head;
        var length = 1;
        while (tail.next != null) {
            tail = tail.next;
            ++length;
        }

        tail.next = head;
        k = k % length;

        var newHead = head;
        for (var i = 0; i < length - k; i++) {
            newHead = newHead.next;
        }

        var newTail = newHead;
        for (var i = 0; i < length - 1; i++) {
            newTail = newTail.next;
        }

        newTail.next = null;

        return newHead;
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