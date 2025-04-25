class Solution {
    
    public int strStr(String haystack, String needle) {

        for (var i = 0;; i++) {
            for (var j = 0;; j++) {

                if (j == needle.length()) {
                    return i;
                }

                if (i + j == haystack.length()) {
                    return -1;
                }

                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
}