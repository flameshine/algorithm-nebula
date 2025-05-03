class Solution {

    public long countSubarrays(int[] nums, long k) {
        
        var sum = 0L;
        var result = 0L;

        for (int i = 0, j = 0; i < nums.length; ++i) {

            sum += nums[i];

            while (sum * (i - j + 1) >= k) {
                sum -= nums[j++];
            }

            result += i - j + 1;
        }

        return result;
    }
}