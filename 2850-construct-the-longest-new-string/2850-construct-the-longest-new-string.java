class Solution {

    public int longestString(int x, int y, int z) {
        
        var builder = new StringBuilder();

        for (var i = 0; i < z; i++) {
            builder.append("AB");
        }

        var min = Math.min(x, y);

        for (var i = 0; i < min; i++) {
            builder.append("AA");
            builder.append("BB");
            --x;
            --y;
        }

        if (x != 0) {
            builder.append("AA");
        }

        if (y != 0) {
            builder.append("BB");
        }

        return builder.length();
    }
}