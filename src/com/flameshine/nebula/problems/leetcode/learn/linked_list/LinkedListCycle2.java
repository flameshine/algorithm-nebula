package com.flameshine.nebula.problems.leetcode.learn.linked_list;

/**
 * №142 Linked List Cycle II
 *
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
 * It is -1 if there is no cycle.
 * Note that pos is not passed as a parameter.
 * Do not modify the linked list.
 */
public class LinkedListCycle2 {

    public static void main(String... args) {

        var node3 = new ListNode(-4);
        var node2 = new ListNode(0, node3);
        var node1 = new ListNode(2, node2);
        var head = new ListNode(3, node1);

        node3.next = node1;

        System.out.println(
            detectCycle(head)
        );
    }

    private static ListNode detectCycle(ListNode head) {

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
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
    }
}