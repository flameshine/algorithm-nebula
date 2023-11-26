package com.flameshine.nebula.problems.leetcode.learn.linked_list;

import java.util.Objects;

/**
 * №2 Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

    public static void main(String... args) {

        var third1 = new ListNode(3);
        var second1 = new ListNode(4, third1);
        var l1 = new ListNode(2, second1);
        var third2 = new ListNode(4);
        var second2 = new ListNode(6, third2);
        var l2 = new ListNode(5, second2);

        System.out.println(
            addTwoNumbers(l1, l2)
        );
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        var dummy = new ListNode();
        var pointer = dummy;
        var carry = 0;

        while (l1 != null || l2 != null) {

            var x = l1 != null ? l1.val : 0;
            var y = l2 != null ? l2.val : 0;
            var sum = x + y + carry;

            carry = sum / 10;

            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }

        return dummy.next;
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