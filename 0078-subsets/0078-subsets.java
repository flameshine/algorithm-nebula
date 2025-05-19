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

        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        backtrack(result, subset, nums, index + 1);
        subset.remove(subset.size() - 1);
        backtrack(result, subset, nums, index + 1);
    } 
}