class Solution {

    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        var result = 1;
        var end = points[0][1];

        for (var i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                ++result;
                end = points[i][1];
            }
        }

        return result;
    }
}