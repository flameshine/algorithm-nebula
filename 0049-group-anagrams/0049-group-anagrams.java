class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<Integer, List<String>> stringsByHashes = new HashMap<>();

        for (var s : strs) {
            stringsByHashes.computeIfAbsent(hash(s), k -> new ArrayList<>())
                .add(s);
        }

        return stringsByHashes.values().stream()
            .toList();
    }

    private static Integer hash(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.hashCode(chars);
    }
}