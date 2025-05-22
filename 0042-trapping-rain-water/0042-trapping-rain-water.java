class Solution {

    public int trap(int[] height) {
        
        if (height.length == 0) {
            return 0;
        }
        
        var result = 0;
        var left = 0;
        var right = height.length - 1;
        var leftMax = 0;
        var rightMax = 0;

        while (left <= right) {

            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            
            if (leftMax < rightMax) {
                result += leftMax - height[left++];
            } else {
                result += rightMax - height[right--];
            }
        }

        return result;
    }
}