class Solution {

    public int minFlips(int a, int b, int c) {
        
        var result = 0;

        for (var i = 0; i < 32; i++) {

            var currentA = a & 1;
            var currentB = b & 1;
            var currentC = c & 1;

            a = a >> 1;
            b = b >> 1;
            c = c >> 1;

            if ((currentA | currentB) != currentC) {

                if (currentA == 1 && currentB == 1) {
                    ++result;
                }

                ++result;
            }
        }

        return result;
    }
}