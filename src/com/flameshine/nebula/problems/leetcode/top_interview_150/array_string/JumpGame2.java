package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

/**
 * №45 Jump Game II
 *
 * You are given a 0-indexed array of integers nums of length n.
 * You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i.
 * In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *   - 0 <= j <= nums[i] and
 *   - i + j < n
 * Return the minimum number of jumps to reach nums[n - 1].
 * The test cases are generated such that you can reach nums[n - 1].
 */
public class JumpGame2 {

    public static void main(String... args) {

        int[] nums = { 2, 3, 1, 1, 4 };

        System.out.println(
            jump(nums)
        );
    }

    private static int jump(int[] nums) {

        var result = 0;
        var end = 0;
        var farthest = 0;

        for (var i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                ++result;
                break;
            }
            if (i == end) {
                ++result;
                end = farthest;
            }
        }

        return result;
    }
}