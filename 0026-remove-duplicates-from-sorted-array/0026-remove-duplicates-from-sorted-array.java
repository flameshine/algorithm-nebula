class Solution {
    public int removeDuplicates(int[] nums) {
        
        Set<Integer> seen = new HashSet<>();
        var result = 0;

        for (var i = 0; i < nums.length; i++) {
            if (seen.add(nums[i])) {
                nums[result++] = nums[i];
            }
        }

        return result;
    }
}