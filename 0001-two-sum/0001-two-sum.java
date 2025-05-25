class Solution {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numberToIndex = new HashMap<>();

        for (var i = 0; i < nums.length; i++) {

            var missing = target - nums[i];

            if (numberToIndex.containsKey(missing)) {
                return new int[] { i, numberToIndex.get(missing) };
            }

            numberToIndex.put(nums[i], i);
        }

        throw new IllegalStateException();
    }
}