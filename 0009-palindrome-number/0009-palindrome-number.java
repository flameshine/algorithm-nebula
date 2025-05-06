class Solution {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        
        var reversed = 0;
        var tmp = x;

        while (tmp != 0) {
            reversed = reversed * 10 + tmp % 10;
            tmp /= 10;
        }

        return x == reversed;
    }
}