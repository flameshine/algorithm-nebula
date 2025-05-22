class Solution {

    public String minRemoveToMakeValid(String s) {
        
        var openingCount = 0;
        var closingCount = 0;

        Stack<Character> stack = new Stack<>();

        for (var c : s.toCharArray()) {

            if (c == '(') {
                ++openingCount;
            }

            if (c == ')') {
                ++closingCount;
            }

            if (closingCount > openingCount) {
                --closingCount;
            } else {
                stack.push(c);
            }
        }

        var resultBuilder = new StringBuilder();

        while (!stack.isEmpty()) {

            var c = stack.pop();

            if (openingCount > closingCount && c == '(') {
                --openingCount;
            } else {
                resultBuilder.append(c);
            }
        }

        return resultBuilder.reverse().toString();
    }
}