class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> numberOccurrences = new HashMap<>();

        for (var n : arr) {
            numberOccurrences.merge(n, 1, Integer::sum);
        }

        var values = numberOccurrences.values();

        return values.size() == Set.copyOf(values).size();
    }
}