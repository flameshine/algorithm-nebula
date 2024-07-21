class Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {
        
        var minimums = new int[matrix.length];
        var maximums = new int[matrix[0].length];

        Arrays.fill(minimums, Integer.MAX_VALUE);
        
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; ++j) {
                minimums[i] = Math.min(minimums[i], matrix[i][j]);
                maximums[j] = Math.max(maximums[j], matrix[i][j]);
            }
        }
        
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == minimums[i] && matrix[i][j] == maximums[j]) {
                    return Collections.singletonList(matrix[i][j]);
                }
            }
        }
        
        return Collections.emptyList();
    }
}