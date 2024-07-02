class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
        
        var counter = 0;

        for (var n : arr) {

            if (counter == 3) {
                return true;
            }

            if (n % 2 == 0) {
                counter = 0;
                continue;
            }

            ++counter;
        }

        return counter == 3;
    }
}