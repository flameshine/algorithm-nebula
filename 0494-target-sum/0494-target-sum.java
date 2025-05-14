class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, 0, 0);
    }

    private static int findTargetSumWays(int[] nums, int target, int i, int sum) {

        if (i >= nums.length && sum == target) {
            return 1;
        }

        if (i >= nums.length) {
            return 0;
        }

        var negative = findTargetSumWays(nums, target, i + 1, sum - nums[i]);
        var positive = findTargetSumWays(nums, target, i + 1, sum + nums[i]);

        return negative + positive;
    }
}