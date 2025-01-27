class Solution {

    public int characterReplacement(String s, int k) {
        
        var frequencies = new int[26];
        var maxFrequency = 0;
        var start = 0;
        var result = 0;

        for (var end = 0; end < s.length(); end++) {

            var current = s.charAt(end);
            
            ++frequencies[current - 'A'];

            maxFrequency = Math.max(maxFrequency, frequencies[current - 'A']);

            if (end - start + 1 - maxFrequency > k) {
                --frequencies[s.charAt(start) - 'A'];
                ++start;
            }

            result = Math.max(result, end - start + 1);
        }

        return result;
    }
}