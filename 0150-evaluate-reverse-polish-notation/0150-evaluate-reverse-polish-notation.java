class Solution {

    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();

        for (var t : tokens) {
            switch (t) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> stack.push(-stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    var x = stack.pop();
                    var y = stack.pop();
                    stack.push(y / x);
                }
                default -> stack.push(Integer.parseInt(t));
            }
        }

        return stack.pop();
    }
}