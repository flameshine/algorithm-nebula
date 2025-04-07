class Solution {

    public int minFlips(int a, int b, int c) {
        
        var flips = 0;

        while (a > 0 || b > 0 || c > 0) {

            var bitA = a & 1;
            var bitB = b & 1;
            var bitC = c & 1;

            if (bitC == 0) {
                flips += bitA + bitB; 
            } else if (bitA == 0 && bitB == 0) {
                ++flips;
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}