class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        
        var zeros = 0;

        for (var n : nums) {
            if (n == 0) {
                ++zeros;
            }
        }
        
        if (zeros > 1) {
            return new int[nums.length];
        }

        if (zeros == 1) {

            var product = 1;
            var index = 0;

            for (var i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    product *= nums[i];
                } else {
                    index = i;
                }
            }

            var result = new int[nums.length];

            result[index] = product;

            return result;
        }

        var product = 1;

        for (var n : nums) {
            product *= n;
        }

        var result = new int[nums.length];

        for (var i = 0; i < nums.length; i++) {
            result[i] = product / nums[i];
        }

        return result;
    }
}