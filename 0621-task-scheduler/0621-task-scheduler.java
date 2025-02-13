class Solution {
    
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> frequencies = new HashMap<>();

        for (var t : tasks) {
            frequencies.merge(t, 1, Integer::sum);
        }

        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        heap.addAll(frequencies.values());

        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();

        var time = 0;

        while (!heap.isEmpty() || !queue.isEmpty()) {

            ++time;

            if (!heap.isEmpty()) {
                var count = heap.poll() - 1;
                if (count != 0) {
                    queue.add(Map.entry(count, time + n));
                }
            }

            if (!queue.isEmpty() && queue.peek().getValue() == time) {
                var newTaskCount = queue.poll().getKey();
                heap.offer(newTaskCount);
            }
        }

        return time;
    }
}