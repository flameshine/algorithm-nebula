class Solution {

    public int pivotIndex(int[] nums) {
        
        var rightSum = 0;

        for (var n : nums) {
            rightSum += n;
        }

        var leftSum = 0;

        for (var i = 0; i < nums.length; i++) {

            rightSum -= nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}