class Solution {

    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> characterCounts1 = new HashMap<>();

        for (var c : s.toCharArray()) {
            characterCounts1.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> characterCounts2 = new HashMap<>();

        for (var c : t.toCharArray()) {
            characterCounts2.merge(c, 1, Integer::sum);
        }

        for (var e : characterCounts1.entrySet()) {
            if (!characterCounts2.containsKey(e.getKey()) || characterCounts2.get(e.getKey()) != e.getValue()) {
                return false;
            }
        }

        return true;
    }
}