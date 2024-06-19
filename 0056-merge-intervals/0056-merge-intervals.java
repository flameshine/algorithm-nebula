class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));
        
        List<int[]> resultBuilder = new ArrayList<>();

        var prev = intervals[0];

        for (var i = 1; i < intervals.length; i++) {
            var current = intervals[i];
            if (current[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], current[1]);
            } else {
                resultBuilder.add(prev);
                prev = current;
            }
        }

        resultBuilder.add(prev);

        return resultBuilder.toArray(new int[resultBuilder.size()][]);
    }
}