class Solution {

    public int mySqrt(int x) {
        
        var left = 1;
        var right = x;

        while (left <= right) {
            var middle = left + (right - left) / 2;
            if (x / middle == middle) {
                return middle;
            } else if (x / middle < middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return right;
    }
}