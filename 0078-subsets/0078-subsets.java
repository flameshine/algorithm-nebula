class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(
        List<List<Integer>> result,
        List<Integer> subset,
        int[] nums,
        int index
    ) {
        result.add(new ArrayList<>(subset));

        for (var i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    } 
}