class Solution {

    public int lastStoneWeight(int[] stones) {
        
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (var s : stones) {
            heap.offer(s);
        }

        while (!heap.isEmpty()) {

            if (heap.size() == 1) {
                return heap.poll();
            }

            var x = heap.poll();
            var y = heap.poll();
            var difference = Math.abs(x - y);

            if (difference != 0) {
                heap.offer(difference);
            }
        }

        return 0;
    }
}