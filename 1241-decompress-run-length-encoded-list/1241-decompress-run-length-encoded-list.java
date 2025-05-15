class Solution {

    public int[] decompressRLElist(int[] nums) {
        
        List<Integer> resultBuilder = new ArrayList<>();

        for (int i = 0, j = 1; j < nums.length; i += 2, j += 2) {

            for (var x = 0; x < nums[i]; x++) {
                resultBuilder.add(nums[j]);
            }
        }

        return resultBuilder.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}