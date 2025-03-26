class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, 1, n);
        return result;
    }

    private static void backtrack(
        List<List<Integer>> result,
        List<Integer> combination,
        int k,
        int start,
        int n
    ) {

        if (combination.size() == k && n == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (var i = start; i <= 9; i++) {
            combination.add(i);
            backtrack(result, combination, k, i + 1, n - i);
            combination.remove(combination.size() - 1);
        }
    }
}