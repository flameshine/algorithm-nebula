class Solution {
    
    public int tribonacci(int n) {

        if (n < 3) {
            return n == 0 ? 0 : 1;
        }

        var result = new int[n + 1];

        result[0] = 0;
        result[1] = 1;
        result[2] = 1;

        for (var i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2] + result[i - 3];
        }

        return result[n];
    }
}