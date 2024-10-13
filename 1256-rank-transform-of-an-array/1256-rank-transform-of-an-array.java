class Solution {

    public int[] arrayRankTransform(int[] arr) {

        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        var distinct = Arrays.stream(arr)
            .distinct()
            .sorted()
            .toArray();
        
        Map<Integer, Integer> valueToRank = new HashMap<>();

        for (var i = 0; i < distinct.length; i++) {
            valueToRank.put(distinct[i], i + 1);
        }

        for (var i = 0; i < arr.length; i++) {
            arr[i] = valueToRank.get(arr[i]);
        }

        return arr;
    }
}