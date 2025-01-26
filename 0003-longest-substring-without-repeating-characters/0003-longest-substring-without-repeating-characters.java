class Solution {

    public int lengthOfLongestSubstring(String s) {
        
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        var result = 0;

        for (var i = 0; i < s.length(); i++) {

            Set<Character> unique = new HashSet<>();

            var currentMax = 0;
            var j = i;

            while (j < s.length()) {
                if (!unique.add(s.charAt(j++))) {
                    break;
                }
                ++currentMax;
            }

            result = Math.max(result, currentMax);
        }

        return result;
    }
}