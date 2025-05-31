class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        
        var left = 0;
        var right = matrix[0].length - 1;
        var top = 0;
        var bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            for (var i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            ++top;

            for (var i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            --right;

            if (top <= bottom) {
                for (var i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                --bottom;
            }

            if (left <= right) {
                for (var i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}