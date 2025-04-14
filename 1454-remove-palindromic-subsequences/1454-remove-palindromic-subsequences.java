class Solution {

    public int removePalindromeSub(String s) {
        return isPalindrome(s) ? 1 : 2;
    }

    private static boolean isPalindrome(String s) {

        var i = 0;
        var j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}