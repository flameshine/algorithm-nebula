class Solution {

    public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<>();

        var number = 0;
        var operator = '+';

        for (var i = 0; i < s.length(); i++) {

            var c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            if (isOperator(c) || i == s.length() - 1) {

                switch (operator) {
                    case '+' -> stack.push(number);
                    case '-' -> stack.push(-number);
                    case '*' -> stack.push(stack.pop() * number);
                    case '/' -> stack.push(stack.pop() / number);
                }

                number = 0;
                operator = c;
            }
        }

        var result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}