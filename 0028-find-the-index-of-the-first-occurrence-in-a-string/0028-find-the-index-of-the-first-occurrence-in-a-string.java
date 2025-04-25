class Solution {
    
    public int strStr(String haystack, String needle) {

        for (var i = 0; i <= haystack.length() - needle.length(); i++) {

            var builder = new StringBuilder();

            for (var j = i; j < i + needle.length(); j++) {
                builder.append(haystack.charAt(j));
            }

            if (builder.toString().equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}