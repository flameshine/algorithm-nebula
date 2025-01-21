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

        return characterCounts1.equals(characterCounts2);
    }
}