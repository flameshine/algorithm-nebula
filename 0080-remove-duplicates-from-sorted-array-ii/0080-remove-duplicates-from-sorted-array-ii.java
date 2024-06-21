class Solution {
    public int removeDuplicates(int[] nums) {
        
        Map<Integer, Integer> counts = new HashMap<>();

        for (var n : nums) {
            counts.merge(n, 1, Integer::sum);
        }

        var result = 0;

        for (var i = 0; i < nums.length; i++) {
            if (counts.get(nums[i]) <= 2) {
                nums[result++] = nums[i];
            } else {
                counts.merge(nums[i], -1, Integer::sum);
            }
        }

        return result;
    }
}