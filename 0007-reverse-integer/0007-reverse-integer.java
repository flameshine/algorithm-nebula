class Solution {
    
    public int reverse(int x) {
        
        var sign = x < 0 ? -1 : 1;
        var reversed = 0;

        x = Math.abs(x);

        while (x != 0) {

            var digit = x % 10;

            x /= 10;

            if (reversed > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }

            reversed = (reversed * 10) + digit;
        }

        reversed *= sign;

        return reversed;
    }
}