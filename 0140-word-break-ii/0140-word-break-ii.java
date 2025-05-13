class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, new HashSet<>(wordDict));
    }

    private static List<String> wordBreak(String s, int start, Set<String> wordDict) {

        List<String> substring = new ArrayList<>();

        if (start == s.length()) {
            substring.add("");
        }

        for (var end = start + 1; end <= s.length(); end++) {
            var prefix = s.substring(start, end);
            if (wordDict.contains(prefix)) {
                var suffixes = wordBreak(s, end, wordDict);
                for (var suffix : suffixes) {
                    substring.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
                }
            }
        }

        return substring;
    }
}