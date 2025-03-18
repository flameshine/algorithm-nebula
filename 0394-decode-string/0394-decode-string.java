class Solution {
    
    public String decodeString(String s) {

        Stack<String> fragments = new Stack<>();
        Stack<Integer> counts = new Stack<>();

        var builder = new StringBuilder();
        var number = 0;

        for (var c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                builder.append(c);
            } else if (c == '[') {
                counts.push(number);
                fragments.push(builder.toString());
                number = 0;
                builder = new StringBuilder();
            } else {
                var count = counts.pop();
                var fragment = new StringBuilder(fragments.pop());
                fragment.append(builder.toString().repeat(Math.max(0, count)));
                builder = fragment;
            }
        }

        return builder.toString();
    }
}