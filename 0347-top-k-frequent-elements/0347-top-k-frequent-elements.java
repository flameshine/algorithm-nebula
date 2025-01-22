class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> numberFrequency = new HashMap<>();

        for (var i : nums) {
            numberFrequency.merge(i, 1, Integer::sum);
        }
        
        Queue<Integer> heap = new PriorityQueue<Integer>((a, b) -> numberFrequency.get(b) - numberFrequency.get(a));

        heap.addAll(numberFrequency.keySet());

        var result = new int[k];

        for (var i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}