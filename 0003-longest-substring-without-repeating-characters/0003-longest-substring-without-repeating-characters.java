class Solution {

    public int lengthOfLongestSubstring(String s) {
        
        var result = 0;
        var i = 0;
        var j = 0;

        Set<Character> seen = new HashSet<>();

        while (j < s.length()) {
            if (seen.contains(s.charAt(j))) {
                seen.remove(s.charAt(i++));
            } else {
                seen.add(s.charAt(j++));
                result = Math.max(result, seen.size());
            }
        }

        return result;
    }
}