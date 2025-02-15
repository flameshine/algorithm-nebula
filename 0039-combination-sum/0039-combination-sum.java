class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        createCombination(candidates, target, 0, new ArrayList<>(), 0, result);
        return result;
    }

    private static void createCombination(
        int[] candidates,
        int target,
        int index,
        List<Integer> combination,
        int currentSum,
        List<List<Integer>> result
    ) {

        if (currentSum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (currentSum > target || index >= candidates.length) {
            return;
        }

        combination.add(candidates[index]);
        createCombination(candidates, target, index, combination, currentSum + candidates[index], result);
        combination.remove(combination.size() - 1);
        createCombination(candidates, target, index + 1, combination, currentSum, result);
    }
}