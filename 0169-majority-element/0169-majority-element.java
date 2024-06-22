class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (var n : nums) {
            var frequency = frequencies.getOrDefault(n, 0);
            if (frequency == nums.length / 2) {
                return n;
            }
            frequencies.put(n, frequency + 1);
        }

        throw new IllegalStateException();
    }
}