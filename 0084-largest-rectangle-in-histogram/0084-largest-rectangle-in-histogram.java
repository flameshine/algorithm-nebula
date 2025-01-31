class Solution {

    public int largestRectangleArea(int[] heights) {
        
        var result = 0;

        Stack<Integer> stack = new Stack<>();

        for (var i = 0; i <= heights.length; i++) {

            var current = i == heights.length ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > current) {
                var height = heights[stack.pop()];
                var width = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = Math.max(result, height * width);
            }

            stack.push(i);
        }

        return result;
    }
}