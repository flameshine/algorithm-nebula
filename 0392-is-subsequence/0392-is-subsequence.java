class Solution {

    public boolean isSubsequence(String s, String t) {
        
        var i = 0;

        for (var c : t.toCharArray()) {
            if (i < s.length() && s.charAt(i) == c) {
                ++i;
            }
        }

        return i == s.length();
    }
}