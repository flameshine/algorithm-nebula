package com.flameshine.nebula.problems.leetcode.learn.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * №147 Insertion Sort List
 *
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
 * The steps of the insertion sort algorithm:
 * 1. Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
 * 2. At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
 * 3. It repeats until no input elements remain.
 * The following is a graphical example of the insertion sort algorithm.
 * The partially sorted list (black) initially contains only the first element in the list.
 * One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
 */
public class InsertionSortList {

    public static void main(String... args) {

        var node3 = new ListNode(-4);
        var node2 = new ListNode(0, node3);
        var node1 = new ListNode(2, node2);
        var head = new ListNode(3, node1);

        System.out.println(
            insertionSortList(head)
        );
    }

    private static ListNode insertionSortList(ListNode head) {

        List<Integer> values = new ArrayList<>();

        var pointer = head;
        while (pointer != null) {
            values.add(pointer.val);
            pointer = pointer.next;
        }

        Collections.sort(values);

        var dummy = new ListNode(-1);

        pointer = dummy;
        for (Integer value : values) {
            pointer.next = new ListNode(value);
            pointer = pointer.next;
        }

        return dummy.next;
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