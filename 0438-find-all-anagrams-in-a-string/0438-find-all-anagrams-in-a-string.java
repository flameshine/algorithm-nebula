class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        
        var pFrequencies = new int[26];

        for (var c : p.toCharArray()) {
            pFrequencies[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();

        var currentFrequencies = new int[26];
        var i = 0;
        var j = 0;

        while (j < s.length()) {

            if (Arrays.equals(pFrequencies, currentFrequencies)) {
                result.add(i);
            }

            if (j - i == p.length()) {
                currentFrequencies[s.charAt(i) - 'a']--;
                ++i;
            }

            currentFrequencies[s.charAt(j++) - 'a']++;
        }

        if (Arrays.equals(pFrequencies, currentFrequencies)) {
            result.add(i);
        }

        return result;
    }
}