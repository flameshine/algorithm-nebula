class Solution {

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> frequencies = new HashMap<>();

        for (var n : nums) {

            frequencies.merge(n, 1, Integer::sum);
            
            if (frequencies.get(n) > nums.length / 2) {
                return n;
            }
        }

        throw new IllegalStateException();
    }
}