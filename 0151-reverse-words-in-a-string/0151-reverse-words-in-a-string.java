class Solution {

    public String reverseWords(String s) {
        
        var result = new StringBuilder();
        var words = s.trim().split("\\s+");

        for (var i = words.length - 1; i >= 0; --i) {

            result.append(words[i]);

            if (i != 0) {
                result.append(' ');
            }
        }

        return result.toString();
    }
}