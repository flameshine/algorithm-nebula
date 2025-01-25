class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        
        if (nums.length == 0) {
            return List.of();
        }

        Arrays.sort(nums);
        
        Set<List<Integer>> resultBuilder = new HashSet<>();

        for (var i = 0; i < nums.length; i++) {

            var j = i + 1;
            var k = nums.length - 1;

            while (j < k) {

                var sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    var triple = List.of(nums[i], nums[j++], nums[k--]);
                    resultBuilder.add(triple);
                } else if (sum < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }

        return new ArrayList<>(resultBuilder);
    }
}