class Solution {

    public int romanToInt(String s) {
        
        var result = 0;
        var previous = 0;

        for (var i = s.length() - 1; i >= 0; i--) {

            var value = switch (s.charAt(i)) {
                case 'M' -> 1000;
                case 'D' -> 500;
                case 'C' -> 100;
                case 'L' -> 50;
                case 'X' -> 10;
                case 'V' -> 5;
                case 'I' -> 1;
                default -> {
                    throw new IllegalStateException();
                }
            };

            if (value < previous) {
                result -= value;
            } else {
                result += value;
            }

            previous = value;
        }

        return result;
    }
}