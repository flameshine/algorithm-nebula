class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        if (nums.length == 0) {
            return List.of();
        }

        Set<List<Integer>> resultBuilder = new HashSet<>();

        for (var i = 0; i < nums.length; i++) {

            Set<Integer> unique = new HashSet<>();

            for (var j = i + 1; j < nums.length; j++) {

                var missing = -nums[i] - nums[j];

                if (unique.contains(missing)) {
                    var triple = List.of(nums[i], nums[j], missing).stream()
                        .sorted()
                        .toList();
                    resultBuilder.add(triple);
                }

                unique.add(nums[j]);
            }
        }

        return new ArrayList<>(resultBuilder);
    }
}