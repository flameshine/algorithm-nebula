class Solution {

    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for (var c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                default -> {
                    if (stack.isEmpty() || c != stack.pop()) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}