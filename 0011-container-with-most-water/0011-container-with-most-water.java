class Solution {

    public int maxArea(int[] heights) {
             
        if (heights.length == 0) {
            return 0;
        }

        var result = 0;
        var left = 0;
        var right = heights.length - 1;

        while (left < right) {

            var current = Math.min(heights[left], heights[right]) * (right - left);

            result = Math.max(result, current);

            if (heights[left] < heights[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return result;
    }
}