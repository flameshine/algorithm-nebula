class Solution {

    public String reverseWords(String s) {
        
        if (s == null || s.isBlank()) {
            return "";
        }

        var normalized = s.trim().replaceAll("\\s+", " ");
        var words = normalized.split(" ");
        var resultBuilder = new StringBuilder(words.length);

        for (var i = words.length - 1; i >= 0; i--) {
            resultBuilder.append(words[i]);
            if (i != 0) {
                resultBuilder.append(" ");
            }
        }

        return resultBuilder.toString();
    }
}