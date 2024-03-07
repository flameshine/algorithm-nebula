package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

/**
 * №27 Remove Element
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

        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };

        System.out.println(
            removeElement(nums, 2)
        );
    }

    private static int removeElement(int[] nums, int val) {

        var result = 0;

        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result++] = nums[i];
            }
        }

        return result;
    }
}