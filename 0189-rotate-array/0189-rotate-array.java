class Solution {

    public void rotate(int[] nums, int k) {

        if (nums.length <= 1 || k == 0) {
            return;
        }

        k = k % nums.length;
        
        var temporary = new int[nums.length];
        var j = 0;

        for (var i = nums.length - k; i < nums.length; i++) {
            temporary[j++] = nums[i];
        }

        for (var i = 0; i < nums.length - k; i++) {
            temporary[j + i] = nums[i];
        }

        for (var i = 0; i < nums.length; i++) {
            nums[i] = temporary[i];
        }
    }
}