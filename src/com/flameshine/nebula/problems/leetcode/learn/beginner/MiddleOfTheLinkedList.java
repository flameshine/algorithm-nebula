package com.flameshine.nebula.problems.leetcode.learn.beginner;

/**
 * №876 Middle of the Linked List
 *
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfTheLinkedList {

    public static void main(String... args) {

        var fifth = new ListNode(5);
        var forth = new ListNode(4, fifth);
        var third = new ListNode(3, forth);
        var second = new ListNode(2, third);
        var head = new ListNode(1, second);

        System.out.println(
            middleNode(head)
        );
    }

    private static ListNode middleNode(ListNode head) {

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static class ListNode {

        private final int val;

        private ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}