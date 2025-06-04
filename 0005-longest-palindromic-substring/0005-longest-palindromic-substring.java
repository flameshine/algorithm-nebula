class Solution {

    public String longestPalindrome(String s) {
        
        var chars = s.toCharArray();
        var start = 0;
        var end = 0;

        for (var i = 0; i < chars.length; i++) {

            var length = Math.max(expand(chars, i, i), expand(chars, i, i + 1));

            if (length > end - start + 1) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expand(char[] chars, int i, int j) {

        while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
            --i;
            ++j;
        }

        return j - i - 1;
    }
}