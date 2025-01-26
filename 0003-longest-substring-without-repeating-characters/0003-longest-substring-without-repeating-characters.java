class Solution {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        var i = 0;
        var j = 0;
        var result = 0;

        Set<Character> seen = new HashSet<>();

        while (j < s.length()) {
            if (!seen.contains(s.charAt(j))) {
                seen.add(s.charAt(j++));
                result = Math.max(result, seen.size());
            } else {
                seen.remove(s.charAt(i++));
            }
        }

        return result;
    }
}