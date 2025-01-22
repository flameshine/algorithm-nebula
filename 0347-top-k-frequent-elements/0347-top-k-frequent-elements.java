class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> numberFrequencies = new HashMap<>();

        for (var i : nums) {
            numberFrequencies.merge(i, 1, Integer::sum);
        }
        
        Queue<Integer> heap = new PriorityQueue<Integer>((a, b) -> numberFrequencies.get(b) - numberFrequencies.get(a));

        heap.addAll(numberFrequencies.keySet());

        var result = new int[k];

        for (var i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}