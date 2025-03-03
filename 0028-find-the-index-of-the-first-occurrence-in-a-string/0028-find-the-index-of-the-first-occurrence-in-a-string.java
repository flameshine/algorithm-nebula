class Solution {
    
    public int strStr(String haystack, String needle) {
        
        for (var i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }

        return -1;
    }
}