class Solution {
    
    public int[] twoSum(int[] nums, int target) {
                
        Map<Integer, Integer> numberToIndex = new HashMap<>();

        for (var i = 0; i < nums.length; i++) {
            var required = target - nums[i];
            if (numberToIndex.containsKey(required)) {
                return new int[] { numberToIndex.get(required), i };
            }
            numberToIndex.put(nums[i], i);
        }

        throw new IllegalStateException();
    }
}