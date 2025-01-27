class Solution {

    public int characterReplacement(String s, int k) {
        
        var counts = new int[26];
        var maxCount = 0;
        var start = 0;
        var result = 0;

        for (var i = 0; i < s.length(); i++) {

            var current = s.charAt(i);

            ++counts[current - 'A'];

            maxCount = Math.max(maxCount, counts[current - 'A']);

            if (i - start + 1 - maxCount > k) {
                counts[s.charAt(start) - 'A']--;
                ++start;
            }

            result = Math.max(result, i - start + 1);
        }

        return result;
    }
}