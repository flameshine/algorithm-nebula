class Solution {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();

        for (var num : nums) {
            set.add(num);
        }

        var longest = 1;

        for (var n : set) {
            if (!set.contains(n - 1)) {
                var count = 1;
                var next = n;
                while (set.contains(next + 1)) {
                    ++next;
                    ++count;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}