class Solution {

    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> prefixSums = new HashMap<>();

        prefixSums.put(0, 1);

        var sum = 0;
        var count = 0;

        for (var n : nums) {
            
            sum += n;

            if (prefixSums.containsKey(sum - k)) {
                count += prefixSums.get(sum - k);
            }

            prefixSums.merge(sum, 1, Integer::sum);
        }

        return count;
    }
}