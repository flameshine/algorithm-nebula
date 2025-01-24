class Solution {

    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> unique = new HashSet<>();

        for (var n : nums) {
            unique.add(n);
        }

        var result = 0;

        for (var n : unique) {

            if (unique.contains(n - 1)) {
                continue;
            }

            var count = 1;
            var next = n;

            while (unique.contains(next++ + 1)) {
                ++count;
            }
            
            result = Math.max(result, count);
        }

        return result;
    }
}