class Solution {

    public String longestPalindrome(String s) {
        
        var result = "";

        for (var i = 0; i < s.length(); i++) {

            var odd = expand(s, i, i);
            var even = expand(s, i, i + 1);

            if (odd.length() > result.length()) {
                result = odd;
            }

            if (even.length() > result.length()) {
                result = even;
            }
        }

        return result;
    }

    private static String expand(String s, int i, int j) {

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }

        return s.substring(i + 1, j);
    }
}