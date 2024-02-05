package com.flameshine.nebula.problems.leetcode.learn.linked_list;

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

        ListNode result = null;
        ListNode current = head;

        while (current != null) {
            if (result == null) {
                result = new ListNode(current.val);
            } else {
                result = new ListNode(current.val, result);
            }
            current = current.next;
        }

        return result;
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
    }
}