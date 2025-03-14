class Solution {

    public int maxOperations(int[] nums, int k) {
    
        Map<Integer, Integer> map = new HashMap<>();

        var result = 0;

        for (var i = 0; i < nums.length; i++) {
            if (map.containsKey(k - nums[i]) && map.get(k - nums[i]) > 0) {
                ++result;
                map.merge(k - nums[i], -1, Integer::sum);
            } else {
                map.merge(nums[i], 1, Integer::sum);
            }
        }

        return result;
    }
}