class Solution {

    public String compressedString(String word) {
        
        var builder = new StringBuilder();
        var count = 1;
        var c = word.charAt(0);

        for (var i = 1; i < word.length(); i++) {
            if (word.charAt(i) == c && count < 9) {
                ++count;
            } else {
                builder.append(count)
                    .append(c);
                c = word.charAt(i);
                count = 1;
            }
        }
        
        builder.append(count)
            .append(c);

        return builder.toString();
    }
}