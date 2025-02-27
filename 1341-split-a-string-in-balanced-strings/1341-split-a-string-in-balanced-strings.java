class Solution {

    public int balancedStringSplit(String s) {
        
        var lCount = 0;
        var rCount = 0;
        var result = 0;

        for (var c : s.toCharArray()) {

            if (c == 'L') {
                lCount++;
            } else {
                rCount++;
            }

            if (lCount == rCount) {
                lCount = 0;
                rCount = 0;
                ++result;
            }
        }

        return result;
    }
}