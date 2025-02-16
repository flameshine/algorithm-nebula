class Solution {

    public List<List<Integer>> permute(int[] nums) {

        if (nums.length == 0) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();

        createPermutation(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private static void createPermutation(
        List<List<Integer>> result,
        List<Integer> permutation,
        int[] nums,
        int index
    ) {

        if (permutation.size() == nums.length) {
            result.add(permutation);
            return;
        }

        for (var i = 0; i <= permutation.size(); i++) {
            List<Integer> updated = new ArrayList<>(permutation);
            updated.add(i, nums[index]);
            createPermutation(result, updated, nums, index + 1);
        }
    }
}