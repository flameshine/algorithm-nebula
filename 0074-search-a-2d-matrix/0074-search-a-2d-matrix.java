class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        
        for (var i = 0; i < matrix.length; i++) {

            var left = 0;
            var right = matrix[i].length - 1;

            while (left <= right) {
                var middle = left + (right - left) / 2;
                if (matrix[i][middle] > target) {
                    right = middle - 1;
                } else if (matrix[i][middle] < target) {
                    left = middle + 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}