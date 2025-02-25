class Solution {

    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    private static boolean isHappy(int n, Set<Integer> seen) {

        if (n == 1) {
            return true;
        }

        if (seen.contains(n)) {
            return false;
        }

        seen.add(n);

        var sum = sumOfSquaredDigits(n);

        return isHappy(sum, seen);
    }

    private static int sumOfSquaredDigits(int n) {

        var sum = 0;

        while (n != 0) {
            var digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}