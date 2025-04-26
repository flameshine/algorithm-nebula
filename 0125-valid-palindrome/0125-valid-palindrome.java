class Solution {

    public boolean isPalindrome(String s) {
        
        var left = 0;
        var right = s.length() - 1;

        while (left < right) {

            var leftChar = s.charAt(left);
            var rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                ++left;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                --right;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                ++left;
                --right;
            }
        }

        return true;
    }
}