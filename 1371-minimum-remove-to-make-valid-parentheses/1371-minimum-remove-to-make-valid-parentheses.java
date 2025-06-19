class Solution {

    public String minRemoveToMakeValid(String s) {

        var count = 0;

        Stack<Character> stack = new Stack<>();

        for (var c : s.toCharArray()) {
            if (c == '(') {
                ++count;
                stack.push(c);
            } else if (c == ')' && count > 0) {
                --count;
                stack.push(c);
            } else if (c != ')') {
                stack.push(c);
            }
        }

        var builder = new StringBuilder();

        while (!stack.isEmpty()) {
            var c = stack.pop();
            if (c == '(' && count > 0) {
                --count;
            } else {
                builder.append(c);
            }
        }

        return builder.reverse()
            .toString();
    }
}