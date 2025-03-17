class Solution {
    
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();

        for (var a : asteroids) {

            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                var difference = a + stack.peek();
                if (difference > 0) {
                    a = 0;
                } else if (difference < 0) {
                    stack.pop();
                } else {
                    a = 0;
                    stack.pop();
                }
            }

            if (a != 0) {
                stack.push(a);
            }
        }

        var result = new int[stack.size()];

        for (var i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}