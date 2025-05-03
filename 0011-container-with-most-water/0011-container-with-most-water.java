class Solution {

    public int maxArea(int[] height) {
        
        var left = 0;
        var right = height.length - 1;
        var area = 0;

        while (left < right) {

            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return area;
    }
}