class Solution {

    public String reverseWords(String s) {
        
        if (s == null || s.isBlank()) {
            return "";
        }

        var words = s.replaceAll("\s+", " ").split(" ");
        var i = 0;
        var j = words.length - 1;

        while (i < j) {
            var tmp = words[i];
            words[i++] = words[j];
            words[j--] = tmp;
        }

        return String.join(" ", words).trim();
    }
}