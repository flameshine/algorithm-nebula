class Solution {

    public boolean isSubsequence(String s, String t) {
        
        var pointer = 0;

        for (var c : t.toCharArray()) {
            if (pointer < s.length() && s.charAt(pointer) == c) {
                ++pointer;
            } 
        }

        return pointer == s.length();
    }
}