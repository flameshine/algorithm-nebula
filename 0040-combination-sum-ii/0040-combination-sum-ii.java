class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        createCombination(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private static void createCombination(
        List<List<Integer>> result,
        List<Integer> combination,
        int[] candidates,
        int index,
        int target
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

            createCombination(result, combination, candidates, index + 1, target - candidates[index]);

            combination.remove(combination.size() - 1);

            while (index < candidates.length - 1 && candidates[index] == candidates[index + 1]) {
                ++index;
            }

            createCombination(result, combination, candidates, index + 1, target);
        }
    }
}