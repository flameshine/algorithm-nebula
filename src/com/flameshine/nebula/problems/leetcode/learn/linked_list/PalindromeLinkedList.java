package com.flameshine.nebula.problems.leetcode.learn.linked_list;

import java.util.Objects;

/**
 * №234 Palindrome Linked List
 *
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */
public class PalindromeLinkedList {

    public static void main(String... args) {

        var head = new ListNode(1);

        System.out.println(
            isPalindrome(head)
        );
    }

    private static boolean isPalindrome(ListNode head) {

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode previous = null;
        ListNode current = slow;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        var left = head;
        var right = previous;

        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
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