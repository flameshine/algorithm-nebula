class Solution {

    public boolean validPalindrome(String s) {
    
        var i = 0;
        var j = s.length() - 1;

        while (i < j) {
            
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }

            ++i;
            --j;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int l, int r) {

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}