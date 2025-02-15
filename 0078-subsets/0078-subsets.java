class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        createSubset(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void createSubset(
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
        createSubset(result, subset, nums, index + 1);
        subset.remove(subset.size() - 1);
        createSubset(result, subset, nums, index + 1);
    }
}