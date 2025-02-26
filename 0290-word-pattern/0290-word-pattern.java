class Solution {

    public boolean wordPattern(String pattern, String s) {

        var words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }
        
        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();

        for (var i = 0; i < pattern.length(); i++) {

            var character = pattern.charAt(i);
            var word = words[i];

            patternToWord.putIfAbsent(character, word);
            wordToPattern.putIfAbsent(word, character);

            if (!patternToWord.get(character).equals(word) || !wordToPattern.get(word).equals(character)) {
                return false;
            }

        }

        return true;
    }
}