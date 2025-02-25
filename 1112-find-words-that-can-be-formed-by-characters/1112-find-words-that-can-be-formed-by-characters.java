class Solution {

    public int countCharacters(String[] words, String chars) {

        var charsFrequency = getFrequency(chars);
        var result = 0;

        for (var word : words) {
            var wordFrequency = getFrequency(word);
            if (canBeFormed(wordFrequency, charsFrequency)) {
                result += word.length();
            }
        }

        return result;
    }

    private static Map<Character, Integer> getFrequency(String s) {

        Map<Character, Integer> result = new HashMap<>();

        for (var c : s.toCharArray()) {
            result.merge(c, 1, Integer::sum);
        }

        return result;
    }

    private static boolean canBeFormed(Map<Character, Integer> wordFrequency, Map<Character, Integer> charsFrequency) {

        for (var e : wordFrequency.entrySet()) {
            if (e.getValue() > charsFrequency.getOrDefault(e.getKey(), 0)) {
                return false;
            }
        }

        return true;
    }
}