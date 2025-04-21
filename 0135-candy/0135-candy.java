class Solution {

    public int candy(int[] ratings) {
        
        var n = ratings.length;
        var candies = new int[n];

        Arrays.fill(candies, 1);

        for (var i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (var i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        var result = 0;

        for (var c : candies) {
            result += c;
        }

        return result;
    }
}