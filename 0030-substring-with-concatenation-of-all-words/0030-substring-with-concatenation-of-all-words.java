class Solution {
    
    public List<Integer> findSubstring(String s, String[] words) {
        
        Map<String, Integer> counts = new HashMap<>();

        for (var word : words) {
            counts.merge(word, 1, Integer::sum);
        }

        List<Integer> indices = new ArrayList<>();

        var wordCount = words.length;
        var wordLength = words[0].length();

        for (var i = 0; i < s.length() - wordCount * wordLength + 1; i++) {
            var substring = s.substring(i, i + wordCount * wordLength);
            if (isConcat(substring, counts, wordLength)) {
                indices.add(i);
            }
        }

        return indices;
    }

    private static boolean isConcat(String substring, Map<String, Integer> counts, int wordLength) {

        Map<String, Integer> seen = new HashMap<>();

        for (var i = 0; i < substring.length(); i += wordLength) {
            var word = substring.substring(i, i + wordLength);
            seen.merge(word, 1, Integer::sum);
        }

        return seen.equals(counts);
    }
}