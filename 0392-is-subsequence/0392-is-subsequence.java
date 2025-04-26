class Solution {

    public boolean isSubsequence(String s, String t) {

        if (s.isBlank() || t.isBlank()) {
            return false;
        }
        
        var i = 0;

        for (var c : t.toCharArray()) {
            if (s.charAt(i) == c) {
                ++i;
            }
        }

        return i == s.length();
    }
}