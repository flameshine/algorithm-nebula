package com.flameshine.nebula.problems.leetcode.learn.linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * №141 Linked List Cycle
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list.
 * Otherwise, return false.
 */
public class LinkedListCycle {

    public static void main(String... args) {

        var node3 = new ListNode(-4);
        var node2 = new ListNode(0, node3);
        var node1 = new ListNode(2, node2);
        var head = new ListNode(3, node1);

        node3.next = node1;

        System.out.println(
            hasCycle(head)
        );
    }

    private static boolean hasCycle(ListNode head) {

        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
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