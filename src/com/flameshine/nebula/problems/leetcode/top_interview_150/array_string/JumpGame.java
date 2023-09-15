package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

/**
 * №55 Jump Game
 *
 * You are given an integer array nums.
 * You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {

    public static void main(String... args) {

        int[] nums = { 3, 2, 1, 0, 4 };

        System.out.println(
            canJump(nums)
        );
    }

    private static boolean canJump(int[] nums) {

        if (nums.length < 2) {
            return true;
        }

        for (var i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                var neededJumps = 1;
                while (neededJumps > nums[i]) {
                    ++neededJumps;
                    --i;
                    if (i < 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}