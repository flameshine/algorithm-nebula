class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> numberToCount1 = new HashMap<>();

        for (var n : nums1) {
            numberToCount1.merge(n, 1, Integer::sum);
        }

        List<Integer> resultBuilder = new ArrayList<>();

        for (var n : nums2) {
            if (numberToCount1.containsKey(n) && numberToCount1.get(n) > 0) {
                resultBuilder.add(n);
                numberToCount1.merge(n, -1, Integer::sum);
            }
        }

        var result = new int[resultBuilder.size()];

        for (var i = 0; i < resultBuilder.size(); i++) {
            result[i] = resultBuilder.get(i);
        }

        return result;
    }
}