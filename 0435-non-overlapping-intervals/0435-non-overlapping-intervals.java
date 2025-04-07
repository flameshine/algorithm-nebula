class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        
        var result = 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        var previousEnd = intervals[0][1];

        for (var i = 1; i < intervals.length; i++) {
            if (previousEnd > intervals[i][0]) {
                ++result;
            } else {
                previousEnd = intervals[i][1];
            }
        }

        return result;
    }
}