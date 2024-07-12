class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> resultBuilder = new ArrayList<>();

        for (var interval : intervals) {
            if (interval[0] > newInterval[1]) {
                resultBuilder.add(newInterval);
                newInterval = interval;
            } else if (interval[1] < newInterval[0]) {
                resultBuilder.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        resultBuilder.add(newInterval);

        return resultBuilder.toArray(new int[resultBuilder.size()][]);
    }
}