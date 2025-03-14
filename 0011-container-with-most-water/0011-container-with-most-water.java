class Solution {

    public int maxArea(int[] heights) {
        
        var left = 0;
        var right = heights.length - 1;
        var result = 0;

        while (left < right) {

            var area = Math.min(heights[left], heights[right] * (right - left));
            
            result = Math.max(result, area);

            if (heights[left] < heights[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return result;
    }
}