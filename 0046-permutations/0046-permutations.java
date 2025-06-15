class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>());
        return result;
    }

    private static void permute(int[] nums, List<List<Integer>> result, List<Integer> current) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (var i = 0; i < nums.length; i++) {

            if (current.contains(nums[i])) {
                continue;
            }

            current.add(nums[i]);
            permute(nums, result, current);
            current.removeLast();
        }
    }
}