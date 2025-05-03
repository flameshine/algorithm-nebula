class Solution {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        var prev = intervals[0];

        for (var i = 1; i < intervals.length; i++) {

            var current = intervals[i];

            if (current[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], current[1]);
            } else {
                result.add(prev);
                prev = current;
            }
        }

        result.add(prev);

        return result.toArray(new int[result.size()][]);
    }
}