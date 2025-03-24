class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        
        Queue<Integer> leftHeap = new PriorityQueue<>();
        Queue<Integer> rightHeap = new PriorityQueue<>();

        var i = 0;
        var j = costs.length - 1;
        var result = 0L;

        while (k-- > 0) {

            while (leftHeap.size() < candidates && i <= j) {
                leftHeap.offer(costs[i++]);
            }

            while (rightHeap.size() < candidates && i <= j) {
                rightHeap.offer(costs[j--]);
            }

            var w1 = leftHeap.size() > 0 ? leftHeap.peek() : Integer.MAX_VALUE;
            var w2 = rightHeap.size() > 0 ? rightHeap.peek() : Integer.MAX_VALUE;

            if (w1 <= w2) {
                result += w1;
                leftHeap.poll();
            } else {
                result += w2;
                rightHeap.poll();
            }
        }

        return result;
    }
}