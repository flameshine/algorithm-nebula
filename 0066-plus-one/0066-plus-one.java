class Solution {
    
    public int[] plusOne(int[] digits) {
        
        for (var i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        var extended = new int[digits.length + 1];

        extended[0] = 1;

        return extended;
    }
}