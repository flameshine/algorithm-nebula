class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        createCombination(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void createCombination(
        int[] candidates,
        int target,
        int index,
        List<Integer> combination,
        List<List<Integer>> result
    ) {

        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (index == candidates.length) {
            return;
        }

        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            createCombination(candidates, target - candidates[index], index, combination, result);
            combination.remove(combination.size() - 1);
        }

        createCombination(candidates, target, index + 1, combination, result);
    }
}