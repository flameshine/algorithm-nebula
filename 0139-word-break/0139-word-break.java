class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private static boolean wordBreak(String s, Set<String> dictionary, Map<String, Boolean> cache) {

        if (s.isEmpty()) {
            return true;
        }

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        for (var i = 0; i < s.length(); i++) {

            var prefix = s.substring(0, i + 1);
            var suffix = s.substring(i + 1);

            if (dictionary.contains(prefix) && wordBreak(suffix, dictionary, cache)) {
                cache.put(s, true);
                return true;
            }
        }

        cache.put(s, false);

        return false;
    }
}