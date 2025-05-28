class Solution {

    public boolean isAnagram(String s, String t) {
        
        var sFrequencies = new int[26];
        var tFrequencies = new int[26];

        for (var c : s.toCharArray()) {
            sFrequencies[c - 'a']++;
        }

        for (var c : t.toCharArray()) {
            tFrequencies[c - 'a']++;
        }

        return Arrays.equals(sFrequencies, tFrequencies);
    }
}