class Solution {
    
    public int calculate(String s) {

        var result = 0;
        var number = 0;
        var sign = 1;

        Stack<Integer> stack = new Stack<>();

        stack.push(sign);

        for (var c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * number;
                number = 0;
                sign = stack.peek() * (c == '+' ? 1 : -1);
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            }
        }

        result += sign * number;

        return result;
    }
}