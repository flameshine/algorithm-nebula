class Solution {

    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    private static boolean isHappy(int n, Set<Integer> seen) {

        if (n == 1) {
            return true;
        }

        if (!seen.add(n)) {
            return false;
        }

        var sumOfSquaredDigits = 0;

        while (n != 0) {
            var digit = n % 10;
            sumOfSquaredDigits += Math.pow(digit, 2);
            n /= 10;
        }

        return isHappy(sumOfSquaredDigits, seen);
    }
}