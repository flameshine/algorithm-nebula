class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private static void combinationSum(
        int[] candidates,
        int remaining,
        List<List<Integer>> accumulator,
        List<Integer> combination,
        int index
    ) {
        
        if (remaining < 0) {
            return;
        }

        if (remaining == 0) {
            accumulator.add(new ArrayList<>(combination));
            return;
        }

        for (var i = index; i < candidates.length; i++) {
            combination.add(candidates[i]);
            combinationSum(candidates, remaining - candidates[i], accumulator, combination, i);
            combination.removeLast();
        }
    }
}