class Solution {

    public String removeStars(String s) {
        
        var builder = new StringBuilder();
        var stars = 0;

        for (var i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                ++stars;
            } else if (stars > 0) {
                --stars;
            } else {
                builder.append(s.charAt(i));
            }
        }

        return builder.reverse()
            .toString();
    }
}