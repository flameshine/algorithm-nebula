class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        createPermutation(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void createPermutation(
        List<List<Integer>> result,
        List<Integer> permutation,
        int[] nums,
        boolean[] visited
    ) {

        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (var i = 0; i < nums.length; i++) {

            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            permutation.add(nums[i]);
            createPermutation(result, permutation, nums, visited);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}