package com.flameshine.nebula.problems.leetcode.top_interview_150;

/**
 * №27
 *
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed.
 * Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 *   - Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 *     The remaining elements of nums are not important as well as the size of nums.
 *   - Return k.
 */
public class RemoveElement {

    public static void main(String... args) {

        int[] nums = { 3, 2, 2, 3 };
        var val = 3;

        System.out.println(
            removeElement(nums, val)
        );
    }

    private static int removeElement(int[] nums, int val) {

        var counter = 0;

        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter++] = nums[i];
            }
        }

        return counter;
    }
}