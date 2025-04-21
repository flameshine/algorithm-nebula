class Solution {

    public int[] productExceptSelf(int[] nums) {
        
        var result = new int[nums.length];

        Arrays.fill(result, 1);

        var current = 1;

        for (var i = 0; i < nums.length; i++) {
            result[i] *= current;
            current *= nums[i];
        }

        current = 1;

        for (var i = nums.length - 1; i >= 0; i--) {
            result[i] *= current;
            current *= nums[i];
        }

        return result;
    }
}