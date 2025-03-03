class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        var max = Integer.MIN_VALUE;

        for (var c : candies) {
            max = Math.max(max, c);
        }

        List<Boolean> result = new ArrayList<>();

        for (var c : candies) {
            result.add(c + extraCandies >= max);
        }

        return result;
    }
}