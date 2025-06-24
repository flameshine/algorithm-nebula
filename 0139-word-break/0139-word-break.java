class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private static boolean wordBreak(String s, Set<String> words, Map<String, Boolean> memory) {

        if (s.length() == 0) {
            return true;
        }

        if (memory.containsKey(s)) {
            return memory.get(s);
        }

        for (var i = 0; i < s.length(); i++) {

            var substring = s.substring(0, i + 1);

            if (words.contains(substring) && wordBreak(s.substring(i + 1), words, memory)) {
                memory.put(s, true);
                return true;
            }
        }

        memory.put(s, false);

        return false;
    }
}