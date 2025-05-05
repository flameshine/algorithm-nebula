class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();

        for (var i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            var j = i + 1;
            var k = nums.length - 1;

            while (j < k) {
                
                var sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {

                    result.add(List.of(nums[i], nums[j], nums[k]));

                    ++j;

                    while (nums[j] == nums[j - 1] && j < k) {
                        ++j;
                    }

                } else if (sum < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }

        return result;
    }
}