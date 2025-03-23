public class Solution extends GuessGame {

    public int guessNumber(int n) {

        var left = 1;
        var right = n;
        
        while (left <= right) {

            var middle = left + (right - left) / 2;
            var guess = guess(middle);

            switch (guess) {
                case -1 -> right = middle - 1;
                case 1 -> left = middle + 1;
                case 0 -> {
                    return middle;
                }
            }
        }

        return -1;
    }
}