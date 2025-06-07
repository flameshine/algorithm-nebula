class Solution {

    public int lengthOfLongestSubstring(String s) {
        
        var i = 0;
        var j = 0;
        var result = 0;

        Set<Character> seen = new HashSet<>();

        while (j < s.length()) {
            if (seen.add(s.charAt(j))) {
                ++j;
                result = Math.max(result, seen.size());
            } else {
                seen.remove(s.charAt(i++));
            }
        }

        return result;
    }
}