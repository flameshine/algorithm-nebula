class Solution {

    public int[] productExceptSelf(int[] nums) {
        
        var zeroes = 0;

        for (var n : nums) {
            if (n == 0) {
                ++zeroes;
            }
        }

        var result = new int[nums.length];

        return switch (zeroes) {
            case 0 -> {
                
                var product = 1;

                for (var n : nums) {
                    product *= n;
                }

                for (var i = 0; i < nums.length; i++) {
                    result[i] = product / nums[i];
                }

                yield result;
            }
            case 1 -> {

                var productExceptZero = 1;
                var zeroIndex = 0;

                for (var i = 0; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        productExceptZero *= nums[i];
                    } else {
                        zeroIndex = i;
                    }
                }

                result[zeroIndex] = productExceptZero;

                yield result;
            }
            default -> result;
        };
    }
}