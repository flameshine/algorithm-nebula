class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        
        var result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (var i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                var index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }

        return result;
    }
}