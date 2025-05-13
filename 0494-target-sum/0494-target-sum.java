class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, nums.length - 1, 0);
    }

    private static int findTargetSumWays(int[] nums, int target, int i, int sum) {

        if (i < 0 && sum == target) {
            return 1;
        }

        if (i < 0) {
            return 0;
        }

        var add = findTargetSumWays(nums, target, i - 1, sum + nums[i]);
        var substruct = findTargetSumWays(nums, target, i - 1, sum - nums[i]);

        return add + substruct;
    }
}