package com.flameshine.nebula.problems.leetcode.top_interview_150.linked_list;

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

        var list1Node2 = new ListNode(4);
        var list2Node2 = new ListNode(4);
        var list1Node1 = new ListNode(2, list1Node2);
        var list2Node1 = new ListNode(3, list2Node2);
        var list1Head = new ListNode(1, list1Node1);
        var list2Head = new ListNode(1, list2Node1);

        System.out.println(
            mergeTwoLists(list1Head, list2Head)
        );
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head;

        if (list1.val > list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }

        head.next = mergeTwoLists(list1, list2);

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
    }
}