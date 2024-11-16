class Solution {

    public boolean isCircularSentence(String sentence) {
        
        if (sentence == null || sentence.isBlank()) {
            return false;
        }

        var words = sentence.split(" ");

        if (words[0].charAt(0) != words[words.length - 1].charAt(words[words.length - 1].length() - 1)) {
            return false;
        }

        for (var i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                return false;
            }
        }

        return true;
    }
}