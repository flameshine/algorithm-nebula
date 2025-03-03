class Solution {
    
    public int strStr(String haystack, String needle) {
        
        for (var i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.startsWith(needle)) {
                return i;
            }
        }

        return -1;
    }
}