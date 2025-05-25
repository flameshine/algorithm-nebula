class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        
        Map<Character, Integer> pFrequencies = new HashMap<>();

        for (var c : p.toCharArray()) {
            pFrequencies.merge(c, 1, Integer::sum);
        }

        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> currentFrequencies = new HashMap<>();

        var i = 0;
        var j = 0;

        while (j < s.length()) {

            if (currentFrequencies.equals(pFrequencies)) {
                result.add(i);
            }

            if (j - i == p.length()) {

                var iChar = s.charAt(i);

                currentFrequencies.merge(iChar, -1, Integer::sum);

                if (currentFrequencies.get(iChar) == 0) {
                    currentFrequencies.remove(iChar);
                }

                ++i;
            }

            currentFrequencies.merge(s.charAt(j++), 1, Integer::sum);
        }

        if (currentFrequencies.equals(pFrequencies)) {
            result.add(i);
        }

        return result;
    }
}