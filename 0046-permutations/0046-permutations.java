class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result, new ArrayList<>());
        return result;
    }

    private static void permute(int[] nums, int index, List<List<Integer>> result, List<Integer> current) {

        if (current.size() == nums.length) {
            result.add(current);
            return;
        }

        for (var i = 0; i <= current.size(); i++) {
            List<Integer> permutation = new ArrayList<>(current);
            permutation.add(i, nums[index]);
            permute(nums, index + 1, result, permutation);
        }
    }
}