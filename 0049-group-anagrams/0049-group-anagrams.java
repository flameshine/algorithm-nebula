class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<Integer, List<String>> stringsByHashes = new HashMap<>();

        for (var s : strs) {
            var hash = buildHash(s);
            var strings = stringsByHashes.getOrDefault(hash, new ArrayList<>());
            strings.add(s);
            stringsByHashes.put(hash, strings);
        }

        return stringsByHashes.values().stream()
            .toList();
    }

    private static int buildHash(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.hashCode(chars);
    }
}