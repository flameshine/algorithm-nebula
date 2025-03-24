class Solution {

    public long maxScore(int[] nums1, int[] nums2, int k) {

        var pairs = new Pair[nums1.length];

        for (var i = 0; i < nums1.length; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }

        Arrays.sort(pairs, (x, y) -> y.b() - x.b());

        Queue<Integer> heap = new PriorityQueue<>(k + 1);

        var result = 0L;
        var sum = 0L;

        for (var p : pairs) {

            heap.add(p.a());
            sum += p.a();

            if (heap.size() > k) {
                sum -= heap.poll();
            }

            if (heap.size() == k) {
                result = Math.max(result, sum * p.b());
            }
        }

        return result;
    }

    private record Pair(int a, int b) {}
}